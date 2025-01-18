package com.atguigu.pojo;

import lombok.Data;

@Data
public class Order {
  private Integer orderId;
  private String orderName;
  private Integer customerId;

  // 一个订单 对应一个客户  一对一
  // 对象 装对应的客户信息
  private Customer customer;// 体现的是对一的关系
}