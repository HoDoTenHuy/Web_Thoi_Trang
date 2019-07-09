<%@ page import="com.danghuy.entity.NhanVienEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
    <div id="header-chitiet" class="container-fluid">
        <nav class="navbar navbar-expand-lg navbar-light none-nav">
            <a class="navbar-brand" href="#"><img src='<c:url value="../../resources/images/logo-yame-shop.png"/>'></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto navbar-center">
                    <li class="nav-item actived">
                        <a class="nav-link" href="#">TRANG CHỦ</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#"
                            role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            SẢN PHẨM
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="#">Action</a>
                            <a class="dropdown-item" href="#">Another action</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Something else here</a>
                        </div>
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
                            <span id="logo-email">${chuCaiDau}</span>
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item">
                                <a class="nav-link" href="dangnhap/">ĐĂNG NHẬP</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <img id="icon-shopping-cart"
                             src='<c:url value="../../resources/images/icon_shopping_cart.png"/>'></a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-sm-2 col-md-2">
                <h3>Danh Mục Sản Phẩm</h3>
                <ul>
                    <li>Áo sơ mi</li>
                    <li>Quần nam</li>
                    <li>Quần nữ</li>
                </ul>
            </div>
            <div class="col-sm-8 col-md-8">
                <div class="row">
                    <div class="col-sm-4 col-md-4">
                        <img alt="" style="max-width: 100%;"
                             src='<c:url value="../../resources/images/sanpham/${chiTietSanPham.hinhSanPham}" />'>
                    </div>
                    <div class="col-sm-8 col-md-8">
                        <h3>${chiTietSanPham.tenSanPham}</h3>
                        <h4>${chiTietSanPham.giaTien}</h4>
                        <table style="width:100%;">
                            <tr>
                                <th>Màu</th>
                                <th>Số Lượng</th>
                                <th>Size</th>
                                <th></th>
                                <th></th>
                            </tr>
                            <c:forEach var = "sanpham" items="${chiTietSanPham.chiTietSanPhamEntities}">
                                <tr>
                                    <td>${sanpham.mauSanPhamEntity.tenMau}</td>
                                    <td>${sanpham.soLuong}</td>
                                    <td>${sanpham.sizeSanPhamEntity.size}</td>
                                    <td>Thêm vào giỏ hàng</td>
                                    <td>Mua ngay</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-sm-2 col-md-2">
                <span>${chiTietSanPham.moTa}</span>
            </div>
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

