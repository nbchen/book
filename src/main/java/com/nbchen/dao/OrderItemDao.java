package com.nbchen.dao;

import com.nbchen.pojo.Order;
import com.nbchen.pojo.OrderItem;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

/**
 * 订单项接口
 */
public interface OrderItemDao {
    // 保存订单项
    int saveOrderItem(OrderItem orderItem);
    // 根据订单号查询订单明细
    List<OrderItem> queryOrderItemByOrderId(String orderId);
}
