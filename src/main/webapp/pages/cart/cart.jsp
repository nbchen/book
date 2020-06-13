<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%--静态文件,包含base标签,css样式,jQuery文件--%>
	<%@include file="/pages/common/head.jsp"%>
	<script>
		$(function () {
			$(".updateCount").change(function () {
				// 商品名称
				var name = $(this).parent().parent().find("td:first").text();
				if (confirm("你确定要将【"+name+"】商品数量修改为: "+this.value+"吗?")) {
					// 保存修改
					// 商品编号,其实用click函数传参也可以,多种方法
					location.href = "${basePath}cartServlet?action=updateCount&count="+this.value+"&id="+$(this).attr('bookId');
				} else {
					// defaultValue 表示表单项DOM的属性,它表示默认的value属性值
					this.value = this.defaultValue
				}
			})
		})
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.png" >
			<span class="wel_word">购物车</span>
		<%--静态宝航,登录成功后的菜单--%>
		<%@include file="/pages/common/login_success_menu.jsp"%>
	</div>
	<div id="main">
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${empty sessionScope.cart.items}">
				<tr>
					<td colspan="5"><a href="index.jsp">亲,当前购物车为空！快跟小伙伴们去浏览商品吧！</a></td>
				</tr>
			</c:if>
			<c:forEach items="${sessionScope.cart.items}" var="entry">
				<tr>
					<td>${entry.value.name}</td>
					<td>
						<input bookId="${entry.value.id}" class="updateCount" type="text" value="${entry.value.count}" style="width: 80px;">
					</td>
					<td>${entry.value.price}</td>
					<td>${entry.value.totalPrice}</td>
					<td><a onclick='return confirm("你确定要删除【${entry.value.name}】吗?")' href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
				</tr>
			</c:forEach>
		</table>
		
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${empty sessionScope.cart ? 0 : sessionScope.cart.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${empty sessionScope.cart ? 0 : sessionScope.cart.totalPrice}</span>元</span>
			<span class="cart_span"><a onclick='return confirm("你确定要清空购物车吗?")' href="cartServlet?action=clear">清空购物车</a></span>
			<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
		</div>
	
	</div>

	<%--静态包含页脚内容--%>
	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>