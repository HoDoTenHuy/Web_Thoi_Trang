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
            <ul class="navbar-nav nav mr-auto navbar-center">
                <li class="nav-item actived">
                    <a class="nav-link" href="/">TRANG CHỦ</a>
                </li>
                <li class="dropdown">
                    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">SẢN PHẨM
                        <span class="caret"></span></button>
                    <ul class="dropdown-menu dropdown-chitiet">
                        <c:forEach var = "danhMuc" items="${listDanhMuc}">
                            <li><a href="../danhmucsanpham/${danhMuc.idDanhMuc}">${danhMuc.tenDanhMuc}</a></li><br/>
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
                            <div class="dropdown-menu" style="margin-left: auto;background: #14556a99 !important;
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
                            <a class="nav-link" href="../login">ĐĂNG NHẬP</a>
                        </li>
                    </c:otherwise>
                </c:choose>
                <li id="giohang" class="nav-item">
                    <a class="nav-link" href="">
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
</div>
<div class="container">
    <h2>Thông Tin Giỏ Hàng Của Bạn</h2>
    <div class="row">
        <div class="col-md-6 col-sm-12">
            <h3>Chi Tiết Sản Phẩm Trong Giỏ Hàng Của Bạn : </h3>
            <table style="width:100%;">
                <tr>
                    <th>Tên Sản Phẩm</th>
                    <th>Màu</th>
                    <th>Size</th>
                    <th>Số Lượng</th>
                    <th>Giá Tiền</th>
                </tr>
                <c:forEach var = "sanpham" items="${listGioHang}">
                    <tr data-machitiet="${sanpham.maChiTiet}">
                        <td class="tensp" data-masp="${sanpham.maSP}">${sanpham.tenSP}</td>
                        <td class="mau" data-mamau="${sanpham.maMau}">${sanpham.tenMau}</td>
                        <td class="size" data-masize="${sanpham.maSize}">${sanpham.tenSize}</td>
                        <td><input class="soluong-giohang" type="number"  min="1"
                                   value="${sanpham.soLuong}"/></td>
                        <td class="giatien" data-giamgia = "${sanpham.khuyenMai}"
                            data-giatien="${sanpham.giaTien}">${sanpham.giaTien}</td>
                        <td class="xoa-giohang btn btn-default btn-sm btn-danger">
                            <span class="glyphicon glyphicon-remove"></span> Remove
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <h4 ->Tổng tiền : <span id="tongtien"></span></h4>
        </div>
        <div class="col-md-6 col-sm-12">
            <h3>Thông Tin Người Mua / Nhận Hàng :</h3>
            <form id="form-thanhtoan">
                <div class="form-group">
                    <label for="tenKhachHang">Tên người mua / nhận hàng : </label>
                    <input type="text" class="form-control" id="tenKhachHang" name="tenKhachHang">
                </div>
                <div class="form-group">
                    <label for="soDienThoai">Số điện thoại : </label>
                    <input type="number" class="form-control" id="soDienThoai" name="soDienThoai">
                </div>
                <div class="radio">
                    <label><input type="radio" name="hinhThucGiaoHang" checked
                                  value="Nhận hàng tại nhà/công ty/bưu điện">
                        Nhận hàng tại nhà/công ty/bưu điện</label>
                </div>
                <div class="radio">
                    <label><input type="radio" name="hinhThucGiaoHang"
                                  value="Nhận hàng tại cửa hàng YaMe gần nhất">
                        Nhận hàng tại cửa hàng YaMe gần nhất</label>
                </div>
                <div class="form-group">
                    <label for="diaChiGiaoHang">Địa chỉ nhận hàng : </label>
                    <input type="text" class="form-control" id="diaChiGiaoHang" name="diaChiGiaoHang">
                </div>
                <div class="form-group">
                    <label for="ghiChu">Ghi chú : </label>
                    <textarea class="form-control" rows="5" id="ghiChu" name="ghiChu"></textarea>
                </div>
                <span id="check-thanhtoan"></span>
                <button type="submit" class="btn btn-primary btn-block">Đặt hàng</button>
            </form>
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
            <input id="email-gopy" class="material-text-input" style="margin-bottom: 8px" type="text" placeholder="Email"/>
            <textarea id="noidung-gopy" rows="4" cols="50" placeholder="Nội Dung"></textarea>
            <button id="btn-gopy" class="material-primary-button">Gửi</button>
        </div>
    </div>
</div>
</body>
<jsp:include page="footer.jsp"/>
</html>


