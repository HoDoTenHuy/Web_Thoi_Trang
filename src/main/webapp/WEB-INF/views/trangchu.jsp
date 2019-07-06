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
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">ĐĂNG NHẬP</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">ĐĂNG KÝ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">
                            <img src='<c:url value="../../resources/images/icon_shopping_cart.png"/>'></a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="event-header container">
            <span>Ngày 17/10 - 23/10/2017</span><br/>
            <span id="event-header-span2">Mua 1 Tặng 1</span><br/>
            <button>Xem Ngay</button>
        </div>
    </div>
    <div id="container-infor" class="container-fluid">
        <div class="row">
            <div class="col-12 col-sm-4 col-md-4 col-xl-4">
                <img class="img-size" src='<c:url value="../../resources/images/icon-chatluong.png" />'><br/>
                <span class="text-size">CHẤT LƯỢNG</span><br/>
                <span>Chúng tôi cam kết sẽ mang lại cho các bạn chất lượng sản phẩm tốt nhất</span>
            </div>
            <div class="col-12 col-sm-4 col-md-4 col-xl-4">
                <img class="img-size" src='<c:url value="../../resources/images/icon_tietkiem.png" />'><br/>
                <span class="text-size">TIẾT KIỆM CHI PHÍ</span><br/>
                <span>Cam kết rẻ nhất Việt Nam giúp các bạn tiết kiệm hơn 20% cho từng sản phẩm</span>
            </div>
            <div class="col-12 col-sm-4 col-md-4 col-xl-4">
                <img class="img-size" src='<c:url value="../../resources/images/icon_giaohang.png" />'><br/>
                <span class="text-size">GIAO HÀNG</span><br/>
                <span>Cam kết giao hàng tận nơi trong ngày. Để mang sản phẩm đến cho khách hàng nhanh nhất</span>
            </div>
        </div>
    </div>
    <div class="title-sanpham container">
        <span>SẢN PHẨM HOT</span>
        <div class="row">
            <div class="card col-md-3 col-sm-6" style="width: 44rem;">
                <div class="sanpham">
                    <img class="card-img-top sanpham-size" src='<c:url value="/resources/images/san_pham.jpg"/>'alt="hinh">
                    <div class="card-body">
                        <h5 class="card-title">Tên Sản Phẩm</h5>
                        <p class="card-text">Giá Tiền</p>
                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>
                    </div>
                </div>
            </div>
            <div class="card col-md-3 col-sm-6" style="width: 44rem;">
                <div class="sanpham">
                    <img class="card-img-top sanpham-size" src='<c:url value="/resources/images/san_pham.jpg"/>'alt="hinh">
                    <div class="card-body">
                        <h5 class="card-title">Tên Sản Phẩm</h5>
                        <p class="card-text">Giá Tiền</p>
                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>
                    </div>
                </div>
            </div>
            <div class="card col-md-3 col-sm-6" style="width: 44rem;">
                <div class="sanpham">
                    <img class="card-img-top sanpham-size" src='<c:url value="/resources/images/san_pham.jpg"/>'alt="hinh">
                    <div class="card-body">
                        <h5 class="card-title">Tên Sản Phẩm</h5>
                        <p class="card-text">Giá Tiền</p>
                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>
                    </div>
                </div>
            </div>
            <div class="card col-md-3 col-sm-6" style="width: 44rem;">
                <div class="sanpham">
                    <img class="card-img-top sanpham-size" src='<c:url value="/resources/images/san_pham.jpg"/>'alt="hinh">
                    <div class="card-body">
                        <h5 class="card-title">Tên Sản Phẩm</h5>
                        <p class="card-text">Giá Tiền</p>
                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>
                    </div>
                </div>
            </div>
            <div class="card col-md-3 col-sm-6" style="width: 44rem;">
                <div class="sanpham">
                    <img class="card-img-top sanpham-size" src='<c:url value="/resources/images/san_pham.jpg"/>'alt="hinh">
                    <div class="card-body">
                        <h5 class="card-title">Tên Sản Phẩm</h5>
                        <p class="card-text">Giá Tiền</p>
                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>
                    </div>
                </div>
            </div>
            <div class="card col-md-3 col-sm-6" style="width: 44rem;">
                <div class="sanpham">
                    <img class="card-img-top sanpham-size" src='<c:url value="/resources/images/san_pham.jpg"/>'alt="hinh">
                    <div class="card-body">
                        <h5 class="card-title">Tên Sản Phẩm</h5>
                        <p class="card-text">Giá Tiền</p>
                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>
                    </div>
                </div>
            </div>
            <div class="card col-md-3 col-sm-6" style="width: 44rem;">
                <div class="sanpham">
                    <img class="card-img-top sanpham-size" src='<c:url value="/resources/images/san_pham.jpg"/>'alt="hinh">
                    <div class="card-body">
                        <h5 class="card-title">Tên Sản Phẩm</h5>
                        <p class="card-text">Giá Tiền</p>
                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>
                    </div>
                </div>
            </div>
            <div class="card col-md-3 col-sm-6" style="width: 44rem;">
                <div class="sanpham">
                    <img class="card-img-top sanpham-size" src='<c:url value="/resources/images/san_pham.jpg"/>'alt="hinh">
                    <div class="card-body">
                        <h5 class="card-title">Tên Sản Phẩm</h5>
                        <p class="card-text">Giá Tiền</p>
                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>
                    </div>
                </div>
            </div>
            <div class="card col-md-3 col-sm-6" style="width: 44rem;">
                <div class="sanpham">
                    <img class="card-img-top sanpham-size" src='<c:url value="/resources/images/san_pham.jpg"/>'alt="hinh">
                    <div class="card-body">
                        <h5 class="card-title">Tên Sản Phẩm</h5>
                        <p class="card-text">Giá Tiền</p>
                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>
                    </div>
                </div>
            </div>
            <div class="card col-md-3 col-sm-6" style="width: 44rem;">
                <div class="sanpham">
                    <img class="card-img-top sanpham-size" src='<c:url value="/resources/images/san_pham.jpg"/>'alt="hinh">
                    <div class="card-body">
                        <h5 class="card-title">Tên Sản Phẩm</h5>
                        <p class="card-text">Giá Tiền</p>
                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>
                    </div>
                </div>
            </div>
            <div class="card col-md-3 col-sm-6" style="width: 44rem;">
                <div class="sanpham">
                    <img class="card-img-top sanpham-size" src='<c:url value="/resources/images/san_pham.jpg"/>'alt="hinh">
                    <div class="card-body">
                        <h5 class="card-title">Tên Sản Phẩm</h5>
                        <p class="card-text">Giá Tiền</p>
                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>
                    </div>
                </div>
            </div>
            <div class="card col-md-3 col-sm-6" style="width: 44rem;">
                <div class="sanpham">
                    <img class="card-img-top sanpham-size" src='<c:url value="/resources/images/san_pham.jpg"/>'alt="hinh">
                    <div class="card-body">
                        <h5 class="card-title">Tên Sản Phẩm</h5>
                        <p class="card-text">Giá Tiền</p>
                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>
                    </div>
                </div>
            </div>
            <div class="card col-md-3 col-sm-6" style="width: 44rem;">
                <div class="sanpham">
                    <img class="card-img-top sanpham-size" src='<c:url value="/resources/images/san_pham.jpg"/>'alt="hinh">
                    <div class="card-body">
                        <h5 class="card-title">Tên Sản Phẩm</h5>
                        <p class="card-text">Giá Tiền</p>
                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>
                    </div>
                </div>
            </div>
            <div class="card col-md-3 col-sm-6" style="width: 44rem;">
                <div class="sanpham">
                    <img class="card-img-top sanpham-size" src='<c:url value="/resources/images/san_pham.jpg"/>'alt="hinh">
                    <div class="card-body">
                        <h5 class="card-title">Tên Sản Phẩm</h5>
                        <p class="card-text">Giá Tiền</p>
                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>
                    </div>
                </div>
            </div>
            <div class="card col-md-3 col-sm-6" style="width: 44rem;">
                <div class="sanpham">
                    <img class="card-img-top sanpham-size" src='<c:url value="/resources/images/san_pham.jpg"/>'alt="hinh">
                    <div class="card-body">
                        <h5 class="card-title">Tên Sản Phẩm</h5>
                        <p class="card-text">Giá Tiền</p>
                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>
                    </div>
                </div>
            </div>
            <div class="card col-md-3 col-sm-6" style="width: 44rem;">
                <div class="sanpham">
                    <img class="card-img-top sanpham-size" src='<c:url value="/resources/images/san_pham.jpg"/>'alt="hinh">
                    <div class="card-body">
                        <h5 class="card-title">Tên Sản Phẩm</h5>
                        <p class="card-text">Giá Tiền</p>
                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<jsp:include page="footer.jsp"/>
</html>
