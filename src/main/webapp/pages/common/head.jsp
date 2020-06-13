<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2020/6/6
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":"
            + request.getServerPort()
            + request.getContextPath() + "/";
    pageContext.setAttribute("basePath",basePath);
%>
<!--写base标签,永远固定相对路径跳转的结果-->
<%--<base href="http://localhost:8080/book/">--%>
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script src="static/script/jquery-1.8.3.min.js"></script>