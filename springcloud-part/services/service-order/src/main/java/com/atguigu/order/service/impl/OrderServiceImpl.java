package com.atguigu.order.service.impl;

import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.order.bean.Order;
import com.atguigu.order.feign.ProductFeignClient;
import com.atguigu.order.service.OrderService;
import com.atguigu.product.bean.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    ProductFeignClient productFeignClient;

    @SentinelResource(value = "createOrder",blockHandler = "createOrderFallback")
    @Override
    public Order createOrder(Long productId, Long userId) {
        // 远程调用
        // Product product = getProductFromRemoteWithLoadBalancerAnnotation(productId);

        // 使用fegin实现远程调用
        Product product = productFeignClient.getProductById(productId);
        Order order = new Order();

        order.setId(1L);
        // 总金额
        BigDecimal totalAmount = product.getPrice().multiply(new BigDecimal(product.getNum()));

        order.setTotalAmount(totalAmount);
        order.setUserId(userId);
        order.setNickName("张三");
        order.setAddress("北京");
        // 远程查询商品列表
        order.setProductList(Arrays.asList(product));

        // try {
        //     SphU.entry("haha");
        // } catch (BlockException e) {
        //     throw new RuntimeException(e);
        // }


        return order;
    }

    // 兜底回调
    public Order createOrderFallback(Long productId, Long userId, BlockException e) {
        log.error("createOrderFallback:{}", e.getMessage());
        Order order = new Order();
        order.setId(0L);
        order.setTotalAmount(new BigDecimal(0));
        order.setUserId(userId);
        order.setNickName("未知用户");
        order.setAddress("异常信息"+e.getClass());
        order.setProductList(Arrays.asList(new Product()));

        return order;
        // return null;
    }


    // 1. 远程调用
    private Product getProductFromRemote(Long productId) {
        // 1. 获取到商品服务所在的所有机器IP+port
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
        ServiceInstance instance = instances.get(0);
        // 2. 根据IP+port远程调用
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/product/" + productId;

        log.info("远程请求:{}", url);

        // 3. 获取到商品信息
        Product product = restTemplate.getForObject(url, Product.class);

        return product;
    }

    // 进阶2: 使用负载均衡
    private Product getProductFromRemoteWithLoadBalancer(Long productId) {
        // 1. 远程调用 获取到商品服务所在的所有机器IP+port
        ServiceInstance choose = loadBalancerClient.choose("service-product");

        // 2. 根据IP+port远程调用
        String url = "http://" + choose.getHost() + ":" + choose.getPort() + "/product/" + productId;

        log.info("远程请求:{}", url);

        // 3. 获取到商品信息
        Product product = restTemplate.getForObject(url, Product.class);

        return product;
    }

    // 进阶3: 基于注解的负载均衡
    private Product getProductFromRemoteWithLoadBalancerAnnotation(Long productId) {
        // 1. 远程调用 获取到商品服务所在的所有机器IP+port
        // ServiceInstance choose = loadBalancerClient.choose("service-product");
        // 2. 根据IP+port远程调用
        // String url = "http://" + choose.getHost() + ":" + choose.getPort() + "/product/" + productId;

        String url = "http://service-product/product/" + productId;

        // 3. 获取到商品信息
        Product product = restTemplate.getForObject(url, Product.class);

        return product;
    }
}
