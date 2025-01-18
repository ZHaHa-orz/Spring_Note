package com.atguigu.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Customer {
  private Integer customerId;
  private String customerName;

  // 一个客户对应多个订单
  // 对多: 装对方类型的集合
  private List<Order> orderList;// 体现的是对多的关系
}