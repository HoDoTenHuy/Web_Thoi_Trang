<%--
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
    <h3>${tenDangNhap} - ${matKhau}</h3>
    <%
        String username = (String) request.getAttribute("tenDangNhap");
        String password = (String) request.getAttribute("matKhau");
    %>
    <%= username + " - " + password%>
</body>
</html>
