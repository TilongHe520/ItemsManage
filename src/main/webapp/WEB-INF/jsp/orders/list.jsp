<%--
  Created by IntelliJ IDEA.
  User: tilon
  Date: 2020/7/8
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单</title>
</head>
<body>
订单：<br>
<table border="1">
    <tr>
        <td>用户id</td>
        <td>商品id</td>
        <td>商品</td>
        <td>单价</td>
        <td>购买数量</td>
        <td>购买时间</td>
        <!--td>操作</td-->
    </tr>
    <c:forEach items="${ordersList}" var="orders">
        <tr>
            <td>${orders.userId}</td>
            <td>${orders.itemId}</td>
            <td>${orders.name}</td>
            <td>${orders.price}</td>
            <td>${orders.number}</td>
            <td>${orders.createtime}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

