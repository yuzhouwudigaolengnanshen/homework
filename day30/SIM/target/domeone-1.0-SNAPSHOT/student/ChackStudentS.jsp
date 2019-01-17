<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/13 0013
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>信息</title>
</head>
<body>
<table border="1" width="100%" style="text-align: center">
    <thead>
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>生日</th>
            <th>性别</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${list}" var="stu">
            <tr>
                <td>${stu.sid}</td>
                <td>${stu.sname}</td>
                <td><fmt:formatDate value="${stu.birthday}" pattern="yyyy-MM-dd"/></td>
                <td>${stu.sex}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<div style="text-align: center">
    <p>
        <a href="student/StudentMenu.jsp"><u>返回菜单</u></a>
    </p>
</div>
</body>
</html>
