<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML>
<html>
<head>
    <title>首页</title>
    <style type="text/css">
        a {
            text-decoration: none;
            color: black;
            font-size: 18px;
        }

        h3 {
            width: 180px;
            height: 38px;
            margin: 100px auto;
            text-align: center;
            line-height: 38px;
            background: deepskyblue;
            border-radius: 4px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    基于SSM框架的管理系统：简单实现增、删、改、查。
                </h1>
            </div>
        </div>
    </div>
</div>
<br><br>
<h3>
    <form class="form-horizontal" action="${pageContext.request.contextPath }/login" method="post">
        <span class="heading">用户登录</span>
        <div class="form-group">
            <input type="text" class="form-control" id="inputEmail3" name="username" placeholder="用户名">
            <i class="fa fa-user"></i>
        </div>
        <div class="form-group help">
            <input type="password" class="form-control" id="inputPassword3" name="password" placeholder="密　码">
            <i class="fa fa-lock"></i>
            <a href="#" class="fa fa-question-circle"></a>
        </div>
        <div class="form-group">
            <button type="button" class="btn btn-default" onclick="window.location.href='/register'">注册</button>
            <button type="submit" class="btn btn-default">登录</button>
        </div>
    </form>
</h3>
</body>

</html>
