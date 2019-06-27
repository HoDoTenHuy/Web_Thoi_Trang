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
    <h3>${username} - ${password}</h3>
    <%
        String username = (String) request.getAttribute("username");
        String password = (String) request.getAttribute("password");
    %>
    <%= username + " - " + password%>
</body>
</html>
