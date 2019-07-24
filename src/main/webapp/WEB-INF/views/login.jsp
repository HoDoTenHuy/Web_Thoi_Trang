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
                <p class="icon-oval-footer oval-footer"><img alt="icon_oval" style="margin-bottom: 6px;"
                                                             src='<c:url value="../../resources/images/icon-oval4.png" />'>
                    <span>Luôn cập nhật xướng thời trang mới nhất</span></p>
                <p class="icon-oval-footer oval-footer"><img alt="icon_oval" style="margin-bottom: 6px;"
                                                             src='<c:url value="../../resources/images/icon-oval4.png" />'>
                    <span>Giảm hơn 50% tất cả các mặt hàng dành cho khách VIP</span></p>
                <p class="icon-oval-footer oval-footer"><img alt="icon_oval" style="margin-bottom: 6px;"
                                                             src='<c:url value="../../resources/images/icon-oval4.png" />'>
                    <span>Tận tình tư vấn để tạo nên phong cách thời trang cho bạn</span></p>
            </div>
        </div>
        <div id="container-login-right">
            <div id="header-top-right" class="header-login">
                <span class="actived" id="dangnhap">Đăng Nhập</span> / <a id="dangky" href="/register">Đăng Ký</a>
            </div>

            <div id="container-center-login-right">
                    <form name='loginForm' action="<c:url value='j_spring_security_login' />" method='POST'>
                            <div id="container-dangnhap">
                                <input id="username" name="username" class="material-text-input input-icon-email"
                                       type="text" placeholder="Email"/><br/>
                                <input id="password" name="password" class="material-text-input input-icon-password"
                                       type="password" placeholder="Password"/><br/>
                                <input id="btndangnhap" class="material-primary-button" type="submit" value="ĐĂNG NHẬP"/><br/>
                            </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    </form>
            </div>
            <span id="text-checklogin">${message}</span>
            <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/login-google&response_type=code
    &client_id=865186781951-lauqbvfaqo76pf0gtbop0sa2pao56tc6.apps.googleusercontent.com&approval_prompt=force">Login With Google</a>
            <div id="container-social-login">
                <img alt="icon_fb" src='<c:url value="../../resources/images/icon_fb21.png"/> '/>
                <img alt="icon_gg" src='<c:url value="../../resources/images/icon_google3.png" />'/>
            </div>
        </div>
    </div>
</div>
</body>
<jsp:include page="footer.jsp"/>
</html>
