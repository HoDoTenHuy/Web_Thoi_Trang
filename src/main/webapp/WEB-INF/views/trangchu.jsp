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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
    <div id="header" class="container-fluid">
        <nav class="navbar navbar-expand-lg navbar-light none-nav">
            <a class="navbar-brand" href="/"><img src='<c:url value="../../resources/images/logo-yame-shop.png"/>'></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav nav mr-auto navbar-center">
                    <li class="nav-item actived">
                        <a class="nav-link" href="/">TRANG CHỦ</a>
                    </li>
                    <li class="dropdown">
                        <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">SẢN PHẨM
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                            <c:forEach var = "danhMuc" items="${listDanhMuc}">
                                <li><a href="danhmucsanpham/${danhMuc.idDanhMuc}">${danhMuc.tenDanhMuc}</a></li><br/>
                            </c:forEach>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">DỊCH VỤ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">LIÊN HỆ</a>
                    </li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <c:choose>
                        <c:when test="${chuCaiDau != null}">
                            <div class="btn-group dropleft">
                                <span id="logo-email" data-toggle="dropdown" aria-haspopup="true"
                                      aria-expanded="false">${chuCaiDau}</span>
                                <div class="dropdown-menu" style="margin-left: auto;background: white !important;
                                                                                width: max-content;">
                                    <a class="dropdown-item">${email}</a>
                                    <c:choose>
                                        <c:when test = "${chucvu eq '[2]'}">
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="/themsanpham">Thêm Sản Phẩm</a>
                                        </c:when>
                                        <c:when test = "${chucvu eq '[3]'}">
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="/dashboard">Quản Lý</a>
                                        </c:when>
                                    </c:choose>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="/giohang/">Giỏ Hàng</a>
                                    <div class="dropdown-divider"></div>
                                    <form action="/j_spring_security_logout" style="margin-left: 23px;" method="POST">
                                        <input type="submit" value="Logout"/>
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    </form>
                                </div>
                            </div>
                        </c:when>
                        <c:when test="${chu != null}">
                            <div class="btn-group dropleft">
                                <img id="logo-email" data-toggle="dropdown" aria-haspopup="true"
                                    aria-expanded="false" src='<c:url value="${google.picture}"/>'/>
                            <div class="dropdown-menu" style="margin-left: auto;background: white !important;
                                                                                width: max-content;">
                                <a class="dropdown-item">${google.email}</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="/giohang/">Giỏ Hàng</a>
                                <div class="dropdown-divider"></div>
                                    <form action="/j_spring_security_logout" style="margin-left: 23px;" method="POST">
                                        <input type="submit" value="Logout"/>
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    </form>
                                </div>
                            </div>
                        </c:when>
                        <c:when test="${chuDau != null}">
                            <div class="btn-group dropleft">
                                <img id="logo-email" data-toggle="dropdown" aria-haspopup="true"
                                     aria-expanded="false" src='<c:url value="${facebook.picture}"/>'/>
                                <div class="dropdown-menu" style="margin-left: auto;background: white !important;
                                                                                width: max-content;">
                                    <a class="dropdown-item">${facebook.email}</a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="/giohang/">Giỏ Hàng</a>
                                    <div class="dropdown-divider"></div>
                                    <form action="/j_spring_security_logout" style="margin-left: 23px;" method="POST">
                                        <input type="submit" value="Logout"/>
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    </form>
                                </div>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item">
                                <a class="nav-link" href="/login">ĐĂNG NHẬP</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                    <li class="nav-item">
                        <a class="nav-link" href="giohang/">
                            <img id="icon-shopping-cart"
                                 src='<c:url value="../../resources/images/icon_shopping_cart.png"/>'>
                                <c:if test = "${sosanpham == 0}">
                                    <div>
                                        <span></span>
                                    </div>
                                </c:if>
                                <c:if test = "${sosanpham > 0}">
                                    <div class="circle-giohang">
                                        <span>${sosanpham}</span>
                                    </div>
                                </c:if>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="event-header container wow flipInX" data-wow-duration="0.6s">
            <span>Ngày 17/10 - 23/10/2017</span><br/>
            <span id="event-header-span2">Mua 1 Tặng 1</span><br/>
            <button>Xem Ngay</button>
        </div>
    </div>
    <div id="container-infor" class="container-fluid">
        <div class="row">
            <div class="col-12 col-sm-4 col-md-4 col-xl-4 wow bounceInLeft" data-wow-duration="1.15s">
                <img class="img-size" src='<c:url value="../../resources/images/icon-chatluong.png" />'><br/>
                <span class="text-size">CHẤT LƯỢNG</span><br/>
                <span>Chúng tôi cam kết sẽ mang lại cho các bạn chất lượng sản phẩm tốt nhất</span>
            </div>
            <div class="col-12 col-sm-4 col-md-4 col-xl-4 wow bounceInUp" data-wow-duration="1.15s"
                 data-wow-delay="0.5s">
                <img class="img-size" src='<c:url value="../../resources/images/icon_tietkiem.png" />'><br/>
                <span class="text-size">TIẾT KIỆM CHI PHÍ</span><br/>
                <span>Cam kết rẻ nhất Việt Nam giúp các bạn tiết kiệm hơn 20% cho từng sản phẩm</span>
            </div>
            <div class="col-12 col-sm-4 col-md-4 col-xl-4 wow bounceInRight" data-wow-duration="1.15s"
                 data-wow-delay="1.65s">
                <img class="img-size" src='<c:url value="../../resources/images/icon_giaohang.png" />'><br/>
                <span class="text-size">GIAO HÀNG</span><br/>
                <span>Cam kết giao hàng tận nơi trong ngày. Để mang sản phẩm đến cho khách hàng nhanh nhất</span>
            </div>
        </div>
    </div>
    <div class="title-sanpham container">
        <div class="wow rollIn"><span>SẢN PHẨM HOT</span></div>
        <div class="row" style="margin-top: 42px">
            <c:forEach var = "sanpham" items="${sanPhamList}">
                <div class="card col-md-3 col-sm-6" style="width: 44rem;">
                    <a href="chitiet/${sanpham.idSanPham}">
                        <div class="sanpham wow pulse">
                            <img class="card-img-top sanpham-size"
                                 src='<c:url value="/resources/images/sanpham/${sanpham.hinhSanPham}"/>'alt="hinh">
                            <div class="card-body">
                                <h5 class="card-title">${sanpham.tenSanPham}</h5>
                                <p class="card-text">${sanpham.giaTien} VNĐ</p>
                            </div>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>
    <div id="footer" class="container-fluid">
        <div class="row">
            <div class="col-sm-4 col-md-4 wow rotateInUpRight">
                <p style="text-align: center;"><span class="title-footer">THÔNG TIN SHOP</span></p>
                <span>YAME là một thương hiệu thời trang đầy uy tín, luôn đảm bảo chất lượng tốt nhất
                 cho khách hàng.</span>
            </div>
            <div class="col-sm-4 col-md-4 wow zoomIn" data-wow-duration="1s">
                <p style="text-align: center;"><span class="title-footer">LIÊN HỆ</span></p>
                <span>Thôn Bình Toàn, Xã Hương Bình, Thị Xã Hương Trà, Tỉnh Thừa Thiên Huế</span>
                <span>danghuyvms@gmail.com</span><br/>
                <span>0707279802</span>
            </div>
            <div class="col-sm-4 col-md-4 wow rotateInUpLeft">
                <p style="text-align: center;"><span class="title-footer">GÓP Ý</span></p>
                <input class="material-text-input" style="margin-bottom: 8px" type="text" placeholder="Email"/>
                <textarea rows="4" cols="50" placeholder="Nội Dung"></textarea>
                <button class="material-primary-button">Gửi</button>
            </div>
        </div>
    </div>
</body>
<jsp:include page="footer.jsp"/>
</html>
