<%--
  Created by IntelliJ IDEA.
  User: tilon
  Date: 2020/7/8
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String appPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>主页</title>
    <style type="text/css">
        td{text-align: center;}
        .td2{text-align: right;}
        .table1{
            border:1px solid #ddd;
            width:900px;
        }
        thead{
            background-color:lightblue;
        }
    </style>
</head>
<body>
欢迎你：${currentUser}
<br>
<%-- 当前用户：${pageScope.currentUser}<!-- (只能在同一个页面中使用) --> <br>
当前用户：${requestScope.currentUser}-${roleName} 有重定向数据就访问不到<br>
当前用户：${sessionScope.currentUser}-${roleName} 可以使用<br> --%>
<hr>
<a href="${pageContext.request.contextPath}/items/add"> 添加商品</a><br>
<hr>
<a href="${pageContext.request.contextPath}/orders/list"> 查看订单</a><br>
<hr>
<table>
    <tr>
        <td>总销售金额：${sum}元</td>

    </tr>
</table>
<c:if test="${empty requestScope.pagemsg}">
    没有任何用户信息！
</c:if>
<c:if test="${!empty requestScope.pagemsg}">
    <table border="1" cellpadding="10" cellspacing="0" class="table1">
        <thead>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>描述</td>
            <td>日期</td>
            <td>总量</td>
            <td>余量</td>
            <td>已售金额</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${requestScope.pagemsg.lists}" var="items">
        <tr>
            <td>${items.name}</td>
            <td>${items.price}</td>
            <td>${items.detail}</td>
            <td>${items.createtime}</td>
            <td>${items.totalcount}</td>
            <td>${items.remaincount}</td>
            <td>${(items.totalcount-items.remaincount)*items.price}</td>
            <td>

                <a href="${pageContext.request.contextPath}/items/delete?id=${items.id}">删除</a>
                &nbsp;<a href="${pageContext.request.contextPath}/items/edit?id=${items.id}">编辑</a>
            </td>
        </tr>

        </c:forEach>
    </table>
</c:if>

<table  border="0" cellspacing="0" cellpadding="0"  width="900px">
    <tr>

        <td class="td2">


            <span>第${requestScope.pagemsg.currentPage }/ ${requestScope.pagemsg.totalpage}页</span>  
            <span>总记录数：${requestScope.pagemsg.totalCount }  每页显示:${requestScope.pagemsg.pageSize}</span>  
            <span>
       <c:if test="${requestScope.pagemsg.currentPage != 1}">
           <a href="${pageContext.request.contextPath }/items/list?currentPage=1">[首页]</a>  
           <a href="${pageContext.request.contextPath }/items/list?currentPage=${requestScope.pagemsg.currentPage-1}">[上一页]</a>  
       </c:if>

       <c:if test="${requestScope.pagemsg.currentPage != requestScope.pagemsg.totalpage}">
           <a href="${pageContext.request.contextPath }/items/list?currentPage=${requestScope.pagemsg.currentPage+1}">[下一页]</a>  
           <a href="${pageContext.request.contextPath }/items/list?currentPage=${requestScope.pagemsg.totalpage}">[尾页]</a>  
       </c:if>
   </span>
        </td>
    </tr>
</table>
</body>
</html>

