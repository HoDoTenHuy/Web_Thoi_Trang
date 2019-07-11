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
        <a class="navbar-brand" href="/"><img src='<c:url value="../../resources/images/logo-yame-shop.png"/>'></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-chitiet navbar-nav mr-auto navbar-center">
                <li class="nav-item actived">
                    <a class="nav-link" href="/" style="color: white !important;">TRANG CHỦ</a>
                </li>
                <li class="dropdown">
                    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">SẢN PHẨM
                        <span class="caret"></span></button>
                    <ul class="dropdown-menu dropdown-chitiet">
                        <c:forEach var = "danhMuc" items="${listDanhMuc}">
                            <li><a href="./../../danhmucsanpham/${danhMuc.idDanhMuc}">${danhMuc.tenDanhMuc}</a>
                            </li><br/>
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
                        <span id="logo-email">${chuCaiDau}</span>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="dangnhap/">ĐĂNG NHẬP</a>
                        </li>
                    </c:otherwise>
                </c:choose>
                <li id="giohang" class="nav-item">
                    <a class="nav-link" href="../giohang/">
                        <img id="icon-shopping-cart"
                             src='<c:url value="../../resources/images/icon_shopping_cart.png"/>'>
                        <c:if test = "${sosanpham == null}">
                            <div>
                                <span>${sosanpham}</span>
                            </div>
                        </c:if>
                        <c:if test = "${sosanpham != null}">
                            <div class="circle-giohang">
                                <span>${sosanpham}</span>
                            </div>
                        </c:if>
                    </a>
                </li>
            </ul>
        </div>
    </nav>
</div>
<div class="container">
    <div class="row" style="margin-top: 20px;">
        <div class="col-sm-2 col-md-2">
            <h3 style="margin: 0;">Danh Mục Sản Phẩm</h3>
            <ul class="my-menu">
                <c:forEach var = "danhMuc" items="${listDanhMuc}">
                    <li><a href=./../../danhmucsanpham/${danhMuc.idDanhMuc}">${danhMuc.tenDanhMuc}</a></li>
                </c:forEach>
            </ul>
        </div>
        <div class="col-sm-10 col-md-10">
            <div class="title-sanpham container">
                <div class="wow rollIn"><span style="color: red">${tenDanhMuc}</span></div>
                <div class="row" style="margin-top: 22px">
                    <c:forEach var = "sanpham" items="${listSanPham}">
                        <div class="card col-md-4 col-sm-6" style="width: 44rem;">
                            <a href="../../../chitiet/${sanpham.idSanPham}">
                                <div class="sanpham wow pulse">
                                    <img class="card-img-top sanpham-size"
                                         src='<c:url value="/resources/images/sanpham/${sanpham.hinhSanPham}"/>'
                                         alt="hinh">
                                    <div class="card-body">
                                        <h5 class="card-title">${sanpham.tenSanPham}</h5>
                                        <p class="card-text">${sanpham.giaTien} VNĐ</p>
                                        <a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </c:forEach>
                </div>
            </div>
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

