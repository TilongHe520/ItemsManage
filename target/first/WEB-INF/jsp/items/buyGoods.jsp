<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String appPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <titel>购买商品</titel>
    </head>

    <body>
    <br>
    欢迎你：${user.username}
    <br>
    <form action="${pageContext.request.contextPath}/items/orderGoods" method="post">
        <table border="1">
            <tr>
                <td>名称</td>
                <td>${item.name}</td>
            </tr>
            <tr>
                <td>单价</td>
                <td>${item.price}</td>
            </tr>
            <tr>
                <td>余量</td>
                <td>${item.remaincount}</td>
            </tr>
            <tr>
                <td>购买数量</td>
                <td><input type="text" name="number" value="${goods.number}"/></td>
            </tr>

            <tr>
                <td colspan="2">
                    <input type="submit" value="购买">
                </td>
            </tr>
        </table>
    </form>
    </body>

</html>