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
                    <span class="actived" id="dangky"
                          style="cursor: pointer;font-size: 42px;font-family: initial;">Đăng Ký</span>
                </div>
                    <div id="container-dangky" style="margin-bottom: 236px;width: 100%">
                            <input id="email" name="email" class="material-text-input register-icon-email input-icon-email"
                                   type="text" placeholder="Email"/><br/>
                            <input id="matkhau" name="matKhau" class="material-text-input input-icon-password"
                                   type="password" placeholder="Mật Khẩu"/><br/>
                            <input id="nhaplaimatkhau" name="nhapLaiMatKhau" class="material-text-input input-icon-password"
                                   type="password" placeholder="Nhập Lại Mật Khẩu"/><br/>
                            <input id="btndangky" class="material-primary-button" type="submit" value="ĐĂNG KÝ"/><br/>
                            <span id="text-checklogin"></span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
    <jsp:include page="footer.jsp"/>
</html>
