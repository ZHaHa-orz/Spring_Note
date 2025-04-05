package com.atguigu.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.order.bean.Order;
import com.atguigu.order.properties.OrderProperties;
import com.atguigu.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @RequestMapping("/api/order")
@Slf4j
// @RefreshScope
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    // @Value("${order.timeout}")
    // String orderTimeout;
    // @Value("${order.auto-confirm}")
    // String orderAutoConfirm;

    @Autowired
    OrderProperties orderProperties;

    @GetMapping("/config")
    public String config(){
        return "order.timeout: " + orderProperties.getTimeout() +
                "; order.auto-confirm: " + orderProperties.getAutoConfirm() +
                "; order.db-url: " + orderProperties.getDbUrl();
    }


    // 创建订单
    @GetMapping("/create")
    public Order createOrder(@RequestParam(value = "userId",required = false) Long userId,
                             @RequestParam(value = "productId",defaultValue = "888") Long productId){
        Order order =  orderService.createOrder(productId, userId);
        return order;
    }

    // 秒杀订单
    @GetMapping("/secKill")
    @SentinelResource(value = "secKill-order",fallback = "secKillFallback")
    public Order secKill(@RequestParam("userId") Long userId,
                             @RequestParam("productId") Long productId){
        Order order =  orderService.createOrder(productId, userId);
        order.setId(Long.MAX_VALUE);
        order.setNickName("秒杀订单");
        return order;
    }
    public Order secKillFallback(Long userId, Long productId, Throwable e){
        System.out.println("secKillFallback.....");
        Order order =  new Order();
        order.setId(productId);
        order.setUserId(userId);
        order.setAddress("异常信息"+e.getClass());
        return order;
    }


    @GetMapping("/writeDb")
    public String writeDb() {
        return "writeDb success......";
    }

    @GetMapping("/readDb")
    public String readDb() {
        log.info("readDb......");
        return "readDb success......";
    }
}
