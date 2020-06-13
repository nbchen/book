package com.nbchen.dao;

import com.nbchen.pojo.Order;

import java.util.List;

// 订单接口
public interface OrderDao {
    // 保存订单
    int saveOrder(Order order);
    // 查询全部订单
    List<Order> queryOrders();
    // 修改订单状态
    int changeOrderStatus(String orderId,Integer status);
    // 根据用户编号查询订单信息
    List<Order> queryOrdersByUserId(Integer userId);
}
