<%--
  Created by IntelliJ IDEA.
  User: 心殇
  Date: 2019/1/14
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%--<%  //利用过滤器可实现通用性         --%>
    <%--//实现未登录先登录功能--%>
    <%--Object user = session.getAttribute("user");--%>
    <%--if (user ==null){--%>
        <%--//方式一:【路径名不会改变  停留在菜单路径】 【一次请求】  请求发送方式--%>
<%--//        request.setAttribute("error","您尚未登录");--%>
<%--//        request.getRequestDispatcher("user/login.jsp").forward(request,response);--%>
        <%--//方式二: 【路径名改变 停留在登录路径】【两次请求】请求重定向--%>
        <%--session.setAttribute("error","您尚未登录");--%>
        <%--response.sendRedirect("../user/login.jsp");--%>

        <%--return;--%>
    <%--}--%>
<%--%>--%>
<html>
<head>
    <title>菜单</title>
</head>
<body>
    <div style="text-align: center">
        <h1 style="text-align: center;color: greenyellow">欢迎${user.username}来到菜单!</h1>
    </div>
    <div>
        <table border="1" width="50%" style="text-align: center ; margin: auto" >
            <thead>
                <tr>
                    <th>Menu</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th>
                        <a href="/findStudent">查看</a>
                    </th>
                </tr>
                <tr>
                    <th>
                        <a href="FindStudentByID.jsp">查询</a>
                    </th>
                </tr>
                <tr>
                    <th>
                        <a href="InsertStudent.jsp">添加</a>
                    </th>
                </tr>
                <tr>
                    <th>
                        <a href="DeleteStudent.jsp">删除</a>
                    </th>
                </tr>
                <tr>
                    <th>
                        <a href="UpdateStudent.jsp">修改</a>
                    </th>
                </tr>
                <tr>
                    <th>
                        <a href="/loginSerlet">注销</a>
                    </th>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>
