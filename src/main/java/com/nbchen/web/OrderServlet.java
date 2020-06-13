package com.nbchen.web;

import com.nbchen.pojo.Cart;
import com.nbchen.pojo.Order;
import com.nbchen.pojo.OrderItem;
import com.nbchen.pojo.User;
import com.nbchen.service.OrderService;
import com.nbchen.service.impl.OrderServiceImpl;
import com.nbchen.utils.JdbcUtils;
import com.nbchen.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orderServlet")
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取ca|rt购物车对象和用户id,生成订单,返回订单编号,请求转发到结账页
        Cart cart = (Cart) req.getSession().getAttribute("cart"); // 购物车
        User loginUser = (User) req.getSession().getAttribute("user"); // 登录用户
        // 如果没有登录,先登录
        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        String orderId = null;
        orderId = orderService.createOrder(cart, loginUser.getId());
//        req.setAttribute("orderId",orderId);
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);
        // 为了防止表单重复提交,用重定向
        req.getSession().setAttribute("orderId",orderId);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }

    protected void showAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取订单列表,转发到订单页面
        List<Order> orders = orderService.showAllOrders();
        req.setAttribute("orders",orders);
        req.getRequestDispatcher("/pages/order/order_manager.jsp").forward(req,resp);
    }
    protected void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        orderService.sendOrder(req.getParameter("orderId"));
//        resp.sendRedirect(req.getContextPath()+"/pages/order/order_manager.jsp");
    }
    protected void showOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 根据订单id,查询订单详情,请求转发到详情页
        List<OrderItem> orderItems = orderService.showOrderDetail(req.getParameter("orderId"));
        req.setAttribute("orderItems",orderItems);
        req.getRequestDispatcher("/pages/order/order_detail.jsp").forward(req,resp);
    }
    protected void showMyOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 根据id获取订单列表,转发到订单页面
        User loginUser = (User) req.getSession().getAttribute("user"); // 登录用户
        // 如果没有登录,先登录
        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        List<Order> orders = orderService.showMyOrders(loginUser.getId());
        req.setAttribute("orders",orders);
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req,resp);
    }
}
