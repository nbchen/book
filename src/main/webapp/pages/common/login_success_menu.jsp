<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2020/6/6
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--静态宝航,登录成功后的菜单--%>
<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临十指弹奏书城</span>
    <a href="orderServlet?action=showMyOrders">我的订单</a>
    <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="index.jsp">返回</a>
</div>