<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 7/1/2019
  Time: 7:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Page Dang Nhap</title>
    <jsp:include page="header.jsp"/>

</head>
<body id="body-login">
    <div id="body-flex-login">
        <div id="container-login">
            <div id="container-login-left">
                <div id="header-left" class="header-login">
                    <span id="text-logo">WELCOME</span><br/>
                    <span id="hint-text-logo">Hãy Tạo Nên Phong Cách Của Bạn Cùng MiniShop!</span>
                </div>
                <div id="footer-left">
                    <p class="oval-footer"><img alt="icon_oval" src='<c:url value="../../resources/images/icon-oval4.png" />'>
                        <span>Luôn cập nhật xướng thời trang mới nhất</span></p>
                    <p class="oval-footer"><img alt="icon_oval" src='<c:url value="../../resources/images/icon-oval4.png" />'>
                         <span>Giảm hơn 50% tất cả các mặt hàng dành cho khách VIP</span></p>
                    <p class="oval-footer"><img alt="icon_oval" src='<c:url value="../../resources/images/icon-oval4.png" />'>
                        <span>Tận tình tư vấn để tạo nên phong cách thời trang cho bạn</span></p>
                </div>
            </div>
            <div id="container-login-right">
                <div id="header-top-right" class="header-login">
                    <span class="actived">Đăng Nhập</span> / <span>Đăng Ký</span>
                </div>

                <div>
                    <form id="container-center-login-right">
                        <input class="material-text-input input-icon-email" type="text" placeholder="Email"/><br/>
                        <input class="material-text-input input-icon-password" type="password" placeholder="Password"/><br/>
                        <input class="material-primary-button" type="submit" value="ĐỒNG Ý"/><br/>
                    </form>
                </div>

                <div id="container-social-login">
                    <img alt="icon_fb" src='<c:url value="../../resources/images/icon-facebook.png"/> '/>
                    <img alt="icon_gg" src='<c:url value="../../resources/images/icon-google.png" />'/>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
