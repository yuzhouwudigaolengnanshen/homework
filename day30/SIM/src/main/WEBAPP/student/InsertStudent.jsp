<%--
  Created by IntelliJ IDEA.
  User: 心殇
  Date: 2019/1/14
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
    <style>

    </style>
    <script>
        function checkid(){
            if (document.getElementById("Sid1").value.length>0){
                return true
            } else {
                return false
            }
        }
        function checkname() {
            if (document.getElementById("Sname1").value.length>0){
                return true
            } else {

                return false
            }
        }
        function checkBrithday() {
            if (document.getElementById("Sbrithday1").value.length>0){
                return true
            } else {
                return false
            }
        }
        function checksex() {
            if (document.getElementById("Ssex1").value.length>0){
                return true
            } else {
                return false
            }
        }
        function check() {
            return checkid()&&checkname()&&checkBrithday()&&checksex();
        }
    </script>
</head>
<body>
    <div id="div1">
        <h1>请输入信息</h1>
        <form action="/InsertStudent" id="form1" onsubmit="return check()">
            <p>学号:<input type="text" name="Sid" id="Sid1" onblur="checkid()">
            <p>姓名:<input type="text" name="Sname" id="Sname1" onblur="checkname()"></p>
            <p>生日:<input type="date" name="Sbrithday" id="Sbrithday1" onblur="checkBrithday()"></p>
            <p>性别:<input type="text" name="Ssex" id="Ssex1" onblur="checksex()"></p>
            <p><input type="submit" value="提交"></p>
        </form>
    </div>
</body>
</html>
