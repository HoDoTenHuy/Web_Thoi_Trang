<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 7/4/2019
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PAGE CHUC VU</title>
</head>
<body>
    ${tenchucvu}
    <form action="/chucvu" method="post">
        <input name="idChucVu" class="material-text-input" style="margin-bottom: 8px" type="text" placeholder="Email"/>
        <textarea name="tenChucVu" rows="4" cols="50" placeholder="Nội Dung"></textarea>
        <button class="material-primary-button">Gửi</button>
    </form>
</body>
</html>
