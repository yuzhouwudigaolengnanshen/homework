<%--
  Created by IntelliJ IDEA.
  User: 心殇
  Date: 2019/1/14
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询</title>
</head>
<body>
    <div style="text-align: center">
        <form action="/FindStudentByID" method="post">
            请输入学号:<input type="text" name="sid">
            <input type="submit" value="提交">
        </form>
    </div>
</body>
</html>
