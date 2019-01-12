<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/6 0006
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function test1() {
            var username = document.getElementById("us").value;
            if (/^\w+$/.test(username)){
                document.getElementById("ustest").innerText = "格式正确";
                return true;
            }else {
                document.getElementById("ustest").innerText = "格式错误";
                return false;
            }
        }
        function test2() {
            var password = document.getElementById("pa").value;
            if (/^\w+$/.test(password)){
                document.getElementById("patest").innerText = "格式正确";
                return true;
            }else {
                document.getElementById("patest").innerText = "格式错误";
                return false;
            }
        }
        function test3() {
            if (test1()&&test2()){
                return true;
            } else {
                return false;
            }
        }
    </script>
</head>
<body>
    <form action="/myform" method="post" onsubmit="test3()">
        <p>用户名<input type="text" name="username"  id="us" onblur="test1()"><span id="ustest"></span></p>
        <p>密码 <input type="password" name="password" id="pa" onblur="test2()"><span id="patest"></span></p>
        <p><input type="submit" value="提交"> </p>
    </form>
</body>
</html>
