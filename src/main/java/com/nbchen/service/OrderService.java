package com.nbchen.service;

import com.nbchen.pojo.Cart;
import com.nbchen.pojo.Order;
import com.nbchen.pojo.OrderItem;

import java.util.List;

// 订单service业务接口
public interface OrderService {
    // 生成订单
    String createOrder(Cart cart,Integer userId);
    // 查询全部订单
    List<Order> showAllOrders();
    // 发货
    int sendOrder(String orderId);
    // 查看订单详情
    List<OrderItem> showOrderDetail(String orderId);
    // 查看我的订单
    List<Order> showMyOrders(Integer userId);
    // 签收清单/确认收货
    int receiverOrder(String orderId);
}
