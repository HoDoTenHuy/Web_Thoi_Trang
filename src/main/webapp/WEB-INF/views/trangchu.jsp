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
    <jsp:include page="header.jsp"/>
</head>
<body>
    <a id="theA" href="dangnhap/">Qua trang Dang Nhap</a><br/>
    <form action="login" method="post">
        <div class="login-box">
            <h1>Login</h1>
            <div class="textbox">
                <input type="text" placeholder="Username" name="" value="">
            </div>
            <div class="textbox">
                <input type="password" placeholder="Password" name="" value="">
            </div>
            <input class="btn" type="button" name="" value="Sign in">
        </div>
    </form>
</body>
</html>
