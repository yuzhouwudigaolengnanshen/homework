<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/17
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<div style="text-align: center">
    <form action="/UpdateStudentByID" method="post">
        请输入学号:<input type="text" name="sid">
        <input type="submit" value="提交">
    </form>
</div>
</body>
</html>
