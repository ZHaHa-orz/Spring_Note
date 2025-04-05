package com.atguigu.order.feign;

import com.atguigu.order.feign.fallback.ProductFeignClientFallback;
import com.atguigu.product.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// fegin 客户端
@FeignClient(value = "service-product",
        fallback = ProductFeignClientFallback.class
        // , path = "/api/product"
        )
public interface ProductFeignClient {
    // mvc注解的两套使用逻辑
    // 1. 标注在Controller上, 是接受这样的请求
    // 2. 标注在FeginClient上, 是发送这样的请求
    @GetMapping("/product/{productId}")
    Product getProductById(@PathVariable("productId") Long productId);
}
