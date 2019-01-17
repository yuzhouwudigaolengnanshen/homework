<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/15 0015
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<div style="text-align: center">
    <h1 style="text-align: center;color: greenyellow">学生信息管理系统!</h1>
</div>
<div style="text-align: center">
    <form action="/login" method="post">
        <p>用户名:<input type="text" name="username"></p>
        <p>密码：<input type="password" name="password" ></p>
        <p>下次自动登录<input type="checkbox" name="aotu_login" value="true"></p>
        <p><input type="submit" value="登录"></p>
    </form>
    <h4 style="color:red;">${error}</h4>
</div>
</body>
</html>
