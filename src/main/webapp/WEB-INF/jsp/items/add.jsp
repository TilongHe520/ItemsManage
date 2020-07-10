<%--
  Created by IntelliJ IDEA.
  User: tilon
  Date: 2020/7/8
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>增加商品</title>

</head>
<body>

<form action="${pageContext.request.contextPath}/items/save" method="post">
    <table border="1">
        <tr>
            <td>名称</td>
            <td><input type="text" name="name" value="${item.name}"></td>
        </tr>
        <tr>
            <td>价格</td>
            <td><input type="text" name="price" value="${item.price}"></td>
        </tr>
        <tr>
            <td>总量</td>
            <td><input type="text" name="totalcount" value="${item.totalcount}"></td>
        </tr>

        <tr>
            <td>余量</td>
            <td><input type="text" name="remaincount" value="${item.remaincount}"></td>
        </tr>
        <tr>
            <td>描述</td>
            <td>
                <textarea cols="20" rows="5" name="detail" >${item.detail}</textarea>
            </td>
        </tr>
        <tr>
            <td>图片</td>
            <td>
                <img src="${item.pic}" width="100px" height="100px">
                <input type="file"  name="itempic1" onchange="submitImage();">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="保存">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
