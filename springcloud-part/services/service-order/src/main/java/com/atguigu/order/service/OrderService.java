package com.atguigu.order.service;

import com.atguigu.order.bean.Order;

public interface OrderService {
    public Order createOrder(Long productId, Long userId);
}
