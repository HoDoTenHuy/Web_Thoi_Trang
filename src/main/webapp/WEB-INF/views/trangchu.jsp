<%@ page import="com.danghuy.entity.NhanVienEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 6/22/2019
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="login">Qua trang Login</a><br/>
    <form action="login" method="post">
        <input type="text" name="tenNhanVien"><br/>
        <input type="text" name="tuoi"><br/>
        <input type="text" name="diaChi"><br/>
        <input type="submit">
    </form>
</body>
</html>
