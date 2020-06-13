<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2020/6/7
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--分页条 start--%>
<div id="page_nav">
    <a href="${page.url}&pageNo=1">首页</a>
    <a href="${page.url}&pageNo=${page.pageNo-1<=0?1:page.pageNo-1}">上一页</a>
    <%--页码输出 start--%>
    <c:choose>
        <%--情况 1：如果总页码小于等于 5 的情况，页码的范围是：1-总页码--%>
        <c:when test="${page.pageTotal<= 5}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${page.pageTotal}"/>
        </c:when>
        <%--情况 2：总页码大于 5 的情况--%>
        <c:when test="${page.pageTotal > 5}">
            <c:choose>
                <%--小情况 1：当前页码为前面 3 个：1，2，3 的情况，页码范围是：1-5.--%>
                <c:when test="${page.pageNo <= 3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>
                <%--小情况 2：当前页码为最后 3 个，8，9，10，页码范围是：总页码减 4 - 总页码--%>
                <c:when test="${page.pageNo >= page.pageTotal-3}">
                    <c:set var="begin" value="${page.pageTotal-4}"/>
                    <c:set var="end" value="${page.pageTotal}"/>
                </c:when>
                <%--小情况 3：4，5，6，7，页码范围是：当前页码减 2 - 当前页码加 2--%>
                <c:otherwise>
                    <c:set var="begin" value="${page.pageNo-2}"/>
                    <c:set var="end" value="${page.pageNo+2}"/>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>
    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${i == page.pageNo}">
            【${page.pageNo}】
        </c:if>
        <c:if test="${i != page.pageNo}">
            <a href="${page.url}&pageNo=${i}">${i}</a>
        </c:if>
    </c:forEach>
    <%--页码输出 end--%>
    <a href="${page.url}&pageNo=${page.pageNo+1>=page.pageTotal?page.pageTotal:page.pageNo+1}">下一页</a>
    <a href="${page.url}&pageNo=${page.pageTotal}">末页</a>
    共${page.pageTotal}页，${page.pageTotalCount}条记录 到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">
</div>
<%--分页条 end--%>
<script>
    $(function () {
        // 跳转到指定页码
        $("#searchPageBtn").click(function () {
            var inputPageNo = $("#pn_input").val();
            if (inputPageNo < 1 || inputPageNo > ${page.pageTotal}) {
                alert("无效页码数")
                return;
            }
            // window.location.href可以获取到浏览器地址栏中的地址,该属性可读可写
            location.href = "${basePath}${page.url}&pageNo="+inputPageNo;
        });
    })
</script>