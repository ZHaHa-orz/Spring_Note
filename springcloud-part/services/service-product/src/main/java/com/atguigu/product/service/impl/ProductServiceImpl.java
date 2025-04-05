package com.atguigu.product.service.impl;

import com.atguigu.product.bean.Product;
import com.atguigu.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProductById(Long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setPrice(new BigDecimal(100));
        product.setProductName("华为手机"+productId);
        product.setNum(100);
        // int i = 1/0;
        // try {
        //     TimeUnit.SECONDS.sleep(100);
        // } catch (InterruptedException e) {
        //     throw new RuntimeException(e);
        // }


        return product;
    }
}
