package com.atguigu.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

@SpringBootTest
public class LoadBalancerTest {
    // @Autowired
    // DiscoveryClient discoveryClient;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Test
    void test() {
        // 获取到某一个微服务的所有服务信息 想负载均衡调用需要写算法
        // discoveryClient.getInstances("service-product");

        // 获取到某一个微服务的一个服务信息
        ServiceInstance choose;
        // 轮询调用
        for (int i = 0; i < 6; i++) {
            choose = loadBalancerClient.choose("service-product");
            System.out.println("choose = " + choose.getHost() + ":" + choose.getPort());
        }
    }

}
