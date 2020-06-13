package com.nbchen.service.impl;

import com.nbchen.dao.BookDao;
import com.nbchen.dao.OrderDao;
import com.nbchen.dao.OrderItemDao;
import com.nbchen.dao.impl.BookDaoImpl;
import com.nbchen.dao.impl.OrderDaoImpl;
import com.nbchen.dao.impl.OrderItemDaoImpl;
import com.nbchen.pojo.*;
import com.nbchen.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

// 订单service业务实现类
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private BookDao bookDao = new BookDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis()+""+userId; // 订单号+用户id,保证唯一
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        orderDao.saveOrder(order);
        int i = 1/ 0;
        // 遍历购物车中每个商品项,转化为订单项,保存到数据库
        for (Map.Entry<Integer, CartItem> cartItemEntry : cart.getItems().entrySet()) {
            CartItem cartItem = cartItemEntry.getValue();
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            orderItemDao.saveOrderItem(orderItem);

            // 更新库存和销量
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getSales() - cartItem.getCount());
            bookDao.updateBook(book);
        }
        // 清空购物车
        cart.clear();

        return orderId;
    }

    @Override
    public List<Order> showAllOrders() {
        return orderDao.queryOrders();
    }

    @Override
    public int sendOrder(String orderId) {
        return orderDao.changeOrderStatus(orderId,1);
    }

    @Override
    public List<OrderItem> showOrderDetail(String orderId) {
        return orderItemDao.queryOrderItemByOrderId(orderId);
    }

    @Override
    public List<Order> showMyOrders(Integer userId) {
        return orderDao.queryOrdersByUserId(userId);
    }

    @Override
    public int receiverOrder(String orderId) {
        return orderDao.changeOrderStatus(orderId,2);
    }
}
