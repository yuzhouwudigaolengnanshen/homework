<%--
  Created by IntelliJ IDEA.
  User: 心殇
  Date: 2019/1/14
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>成功</title>
</head>
<body>
    <div>
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
            <tr>
                <td>${s.sid}</td>
                <td>${s.sname}</td>
                <td><fmt:formatDate value="${s.birthday}" pattern="yyyy-MM-dd"/></td>
                <td>${s.sex}</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div style="text-align: center">
        <p>
            <a href="student/FindStudentByID.jsp"><u>重新查询</u></a>
        </p>
        <p>
            <a href="student/StudentMenu.jsp"><u>返回菜单</u></a>
        </p>
    </div>
</body>
</html>
