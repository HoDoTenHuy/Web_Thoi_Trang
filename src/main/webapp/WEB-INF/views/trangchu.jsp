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
    <h3>${username} - ${password}</h3>
    <h2>${nhanVien.toString()}</h2>
    <h1>${listNV}</h1>
    <%
        String username = (String) request.getAttribute("username");
        String password = (String) request.getAttribute("password");
        NhanVienEntity nhanVien = (NhanVienEntity) request.getAttribute("nhanVien");
        List<NhanVienEntity> listNhanVien = (List<NhanVienEntity>) request.getAttribute("listNV");
        for(NhanVienEntity value : listNhanVien){
    %>
            <%= value.toString()%><br/>
        <%}%>
    <%= username + " - " + password%><br/>
    <%= nhanVien.toString()%>
</body>
</html>
