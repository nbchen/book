package com.nbchen.dao.impl;

import com.nbchen.dao.OrderItemDao;
import com.nbchen.pojo.Order;
import com.nbchen.pojo.OrderItem;

import java.util.List;

// 订单项实现类
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO `book`.`t_order_item`(`name`, `count`, `price`, `total_price`,`order_id`) VALUES (?, ?, ?, ?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderItemByOrderId(String orderId) {
        String sql = "select `id` , `name`, `count`,`price`,  `total_price` totalPrice, `order_id` userId from t_order_item where order_id = ?";
        return queryForList(OrderItem.class,sql,orderId);
    }
}
