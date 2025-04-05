package com.atguigu.product.controller;

import com.atguigu.product.bean.Product;
import com.atguigu.product.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RequestMapping("/api/product")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;
    // 获取商品信息

    @GetMapping("/product/{productId}")
    public Product getProduct(@PathVariable("productId") Long productId,
                              HttpServletRequest request) {
        String header = request.getHeader("X-Token");
        System.out.println("hello, token: " + header);
        Product product = productService.getProductById(productId);
        return product;
    }

}
