<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Easy Admin Panel an Admin Panel Category Flat Bootstrap Responsive Website Template | Home :: w3layouts</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Easy Admin Panel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.min.css"/> '/>
    <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/style.css"/> '/>
    <%--<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/styles.css"/> '/>--%>
    <!-- Graph CSS -->
    <link rel="stylesheet" href='<c:url value="/resources/css/font-awesome.css"/> '/>
    <!-- jQuery -->
    <!-- lined-icons -->
    <link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/icon-font.min.css"/> '/>
    <!-- //lined-icons -->
    <!-- chart -->
    <script src='<c:url value="/resources/js/Chart.js"/> '></script>
    <!-- //chart -->
    <!--animate-->
    <link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/animate2.css"/> '/>
    <script src='<c:url value="/resources/js/wow2.min.js"/> '></script>
    <script>
        new WOW().init();
    </script>
    <!--//end-animate-->
    <!----webfonts--->
    <link href='<c:url value="//fonts.googleapis.com/css?family=Cabin:400,400italic,500,500italic,600,600italic,700,700italic"/>' rel='stylesheet' type='text/css'/>
    <!---//webfonts--->
    <!-- Meters graphs -->
    <script src='<c:url value="/resources/js/jquery-1.10.22.min.js"/> '></script>
    <!-- Placed js at the end of the document so the pages load faster -->

</head>

<body class="sticky-header left-side-collapsed"  onload="initMap()">
<section>
    <!-- left side start-->
    <div class="left-side sticky-left-side">

        <!--logo and iconic logo start-->
        <div class="logo">
            <h1><a href="../">Easy <span>Admin</span></a></h1>
        </div>
        <div class="logo-icon text-center">
            <a href="../dashboard"><i class="lnr lnr-home"></i> </a>
        </div>

        <!--logo and iconic logo end-->
        <div class="left-side-inner">

            <!--sidebar nav start-->
            <ul class="nav nav-pills nav-stacked custom-nav">
                <li class="menu-list">
                    <a><i class="lnr lnr-store"></i>
                        <span>Sản Phẩm</span></a>
                    <ul class="sub-menu-list">
                        <li><a href="../quanlysanpham">Chi Tiết Sản Phẩm</a> </li>
                        <li><a href="../themsanpham">Thêm - Sửa - Xóa</a> </li>
                        <li><a href="../themsize">Thêm Loại Size</a> </li>
                        <li><a href="../themmau">Thêm Màu</a> </li>
                        <li><a href="../themdanhmuc">Thêm Danh Mục</a> </li>
                    </ul>
                </li>
                <li class="menu-list"><a href="#"><i class="lnr lnr-book"></i> <span>Đơn Hàng</span></a>
                    <ul class="sub-menu-list">
                        <li><a href="../tatcadonhang">Tất Cả Đơn Hàng</a> </li>
                        <li><a href="../duyetdonhang">Quản Lý Đơn Hàng</a> </li>
                    </ul>
                </li>
                <li class="menu-list"><a href="#"><i class="lnr lnr-envelope"></i> <span>MailBox</span></a>
                    <ul class="sub-menu-list">
                        <li><a href="">Inbox</a> </li>
                        <li><a href="../gopy">Mail Góp ý</a></li>
                    </ul>
                </li>
                <li class="menu-list"><a href="#"><i class="lnr lnr-indent-increase"></i> <span>Menu Levels</span></a>
                    <ul class="sub-menu-list">
                        <li><a href="charts.html">Basic Charts</a> </li>
                    </ul>
                </li>
                <li><a href="codes.html"><i class="lnr lnr-pencil"></i> <span>Typography</span></a></li>
                <li><a href="media.html"><i class="lnr lnr-select"></i> <span>Media Css</span></a></li>
                <li class="menu-list"><a href="#"><i class="lnr lnr-book"></i>  <span>Pages</span></a>
                    <ul class="sub-menu-list">
                        <li><a href="sign-in.html">Sign In</a> </li>
                        <li><a href="sign-up.html">Sign Up</a></li>
                        <li><a href="blank_page.html">Blank Page</a></li>
                    </ul>
                </li>
            </ul>
            <!--sidebar nav end-->
        </div>
    </div>
    <!-- left side end-->

    <!-- main content start-->
    <div class="main-content">
        <!-- header-starts -->
        <div class="header-section">

            <!--toggle button start-->
            <a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
            <!--toggle button end-->

            <!--notification menu start -->
            <div class="menu-right">
                <div class="user-panel-top">
                    <div class="profile_details_left">
                        <ul class="nofitications-dropdown">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i
                                        class="fa fa-envelope"></i><span class="badge">3</span></a>

                                <ul class="dropdown-menu">
                                    <li>
                                        <div class="notification_header">
                                            <h3>You have 3 new messages</h3>
                                        </div>
                                    </li>
                                    <li><a href="#">
                                        <div class="user_img"><img src="images/1.png" alt=""></div>
                                        <div class="notification_desc">
                                            <p>Lorem ipsum dolor sit amet</p>
                                            <p><span>1 hour ago</span></p>
                                        </div>
                                        <div class="clearfix"></div>
                                    </a></li>
                                    <li class="odd"><a href="#">
                                        <div class="user_img"><img src="images/1.png" alt=""></div>
                                        <div class="notification_desc">
                                            <p>Lorem ipsum dolor sit amet </p>
                                            <p><span>1 hour ago</span></p>
                                        </div>
                                        <div class="clearfix"></div>
                                    </a></li>
                                    <li><a href="#">
                                        <div class="user_img"><img src="images/1.png" alt=""></div>
                                        <div class="notification_desc">
                                            <p>Lorem ipsum dolor sit amet </p>
                                            <p><span>1 hour ago</span></p>
                                        </div>
                                        <div class="clearfix"></div>
                                    </a></li>
                                    <li>
                                        <div class="notification_bottom">
                                            <a href="#">See all messages</a>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <li class="login_box" id="loginContainer">
                                <div class="search-box">
                                    <div id="sb-search" class="sb-search">
                                        <form>
                                            <input class="sb-search-input" placeholder="Enter your search term..."
                                                   type="search" id="search">
                                            <input class="sb-search-submit" type="submit" value="">
                                            <span class="sb-icon-search"> </span>
                                        </form>
                                    </div>
                                </div>
                                <!-- search-scripts -->
                                <script src='<c:url value="/resources/js/classie.js"/> '></script>
                                <script src='<c:url value="/resources/js/uisearch.js"/> '></script>
                                <script>
                                    new UISearch( document.getElementById( 'sb-search' ) );
                                </script>
                                <!-- //search-scripts -->
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i
                                        class="fa fa-bell"></i><span class="badge blue">3</span></a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <div class="notification_header">
                                            <h3>You have 3 new notification</h3>
                                        </div>
                                    </li>
                                    <li><a href="#">
                                        <div class="user_img"><img src="images/1.png" alt=""></div>
                                        <div class="notification_desc">
                                            <p>Lorem ipsum dolor sit amet</p>
                                            <p><span>1 hour ago</span></p>
                                        </div>
                                        <div class="clearfix"></div>
                                    </a></li>
                                    <li class="odd"><a href="#">
                                        <div class="user_img"><img src="images/1.png" alt=""></div>
                                        <div class="notification_desc">
                                            <p>Lorem ipsum dolor sit amet </p>
                                            <p><span>1 hour ago</span></p>
                                        </div>
                                        <div class="clearfix"></div>
                                    </a></li>
                                    <li><a href="#">
                                        <div class="user_img"><img src="images/1.png" alt=""></div>
                                        <div class="notification_desc">
                                            <p>Lorem ipsum dolor sit amet </p>
                                            <p><span>1 hour ago</span></p>
                                        </div>
                                        <div class="clearfix"></div>
                                    </a></li>
                                    <li>
                                        <div class="notification_bottom">
                                            <a href="#">See all notification</a>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i
                                        class="fa fa-tasks"></i><span class="badge blue1">22</span></a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <div class="notification_header">
                                            <h3>You have 8 pending task</h3>
                                        </div>
                                    </li>
                                    <li><a href="#">
                                        <div class="task-info">
                                            <span class="task-desc">Database update</span>
                                            <span class="percentage">40%</span>
                                            <div class="clearfix"></div>
                                        </div>
                                        <div class="progress progress-striped active">
                                            <div class="bar yellow" style="width:40%;"></div>
                                        </div>
                                    </a></li>
                                    <li><a href="#">
                                        <div class="task-info">
                                            <span class="task-desc">Dashboard done</span>
                                            <span class="percentage">90%</span>
                                            <div class="clearfix"></div>
                                        </div>

                                        <div class="progress progress-striped active">
                                            <div class="bar green" style="width:90%;"></div>
                                        </div>
                                    </a></li>
                                    <li><a href="#">
                                        <div class="task-info">
                                            <span class="task-desc">Mobile App</span><span class="percentage">33%</span>
                                            <div class="clearfix"></div>
                                        </div>
                                        <div class="progress progress-striped active">
                                            <div class="bar red" style="width: 33%;"></div>
                                        </div>
                                    </a></li>
                                    <li><a href="#">
                                        <div class="task-info">
                                            <span class="task-desc">Issues fixed</span>
                                            <span class="percentage">80%</span>
                                            <div class="clearfix"></div>
                                        </div>
                                        <div class="progress progress-striped active">
                                            <div class="bar  blue" style="width: 80%;"></div>
                                        </div>
                                    </a></li>
                                    <li>
                                        <div class="notification_bottom">
                                            <a href="#">See all pending task</a>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <div class="clearfix"></div>
                        </ul>
                    </div>
                    <div class="profile_details">
                        <ul>
                            <li class="dropdown profile_details_drop">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                    <div class="profile_img">
                                        <span style="background:url(images/1.jpg) no-repeat center"> </span>
                                        <div class="user-name">
                                            <p>Michael<span>Administrator</span></p>
                                        </div>
                                        <i class="lnr lnr-chevron-down"></i>
                                        <i class="lnr lnr-chevron-up"></i>
                                        <div class="clearfix"></div>
                                    </div>
                                </a>
                                <ul class="dropdown-menu drp-mnu">
                                    <li> <a href="#"><i class="fa fa-cog"></i> Settings</a> </li>
                                    <li> <a href="#"><i class="fa fa-user"></i>Profile</a> </li>
                                    <li> <a href="sign-up.html"><i class="fa fa-sign-out"></i> Logout</a> </li>
                                </ul>
                            </li>
                            <div class="clearfix"> </div>
                        </ul>
                    </div>
                    <div class="social_icons">
                        <div class="col-md-4 social_icons-left">
                            <a href="#" class="yui"><i class="fa fa-facebook i1"></i>
                                <span>300<sup>+</sup> Likes</span></a>
                        </div>
                        <div class="col-md-4 social_icons-left pinterest">
                            <a href="#"><i class="fa fa-google-plus i1"></i><span>500<sup>+</sup> Shares</span></a>
                        </div>
                        <div class="col-md-4 social_icons-left twi">
                            <a href="#"><i class="fa fa-twitter i1"></i><span>500<sup>+</sup> Tweets</span></a>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
            <!--notification menu end -->
        </div>
        <!-- //header-ends -->
        <div id="page-wrapper" class="container-fluid">
            <div class="row">
                <h3>Nhân Viên - User</h3>
                <div class="col-md-12 col-sm-12">
                    <table id="table-nhanvien" class="table">
                        <thead>
                        <tr>
                            <th>ID Nhân Viên</th>
                            <th>Tên Nhân Viên</th>
                            <th>Email</th>
                            <th>Username</th>
                            <th>Chức Vụ</th>
                            <th>Địa Chỉ</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody style="border-bottom: 0.5px outset;">
                        <c:forEach var = "nhanvien" items="${listNhanVien}">
                            <tr>
                                <td class="idnhanvien" data-manv="">${nhanvien.idNhanVien}</td>
                                <td class="tennhanvien" data-tennv="">${nhanvien.hoTen}</td>
                                <td class="email-nv" data-email="">${nhanvien.email}</td>
                                <td class="username-nv" data-username="">${nhanvien.tenDangNhap}</td>
                                <td class="chucvu-nv" data-chucvu="${nhanvien.chucVuEntities}">
                                    <c:if test = "${nhanvien.chucVuEntities eq '[3]'}">
                                        <p>Manager<p>
                                    </c:if>
                                    <c:if test = "${nhanvien.chucVuEntities eq '[2]'}">
                                        <p>Admin<p>
                                    </c:if>
                                    <c:if test = "${nhanvien.chucVuEntities eq '[1]'}">
                                        <p>User<p>
                                    </c:if>
                                </td>
                                <td class="diachi-nv" data-diachi="">${nhanvien.diaChi}</td>
                                <td class="capnhat-nhanvien" style="padding-top: 8px !important;"
                                    data-btn-manv="${nhanvien.idNhanVien}">
                                    <button type="button" class="btn btn-secondary">Cập Nhật</button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <ul class="pagination pagination-sm">
                        <c:forEach var="index" begin="1" end="${tongPage}">
                            <c:choose>
                                <c:when test = "${index == 1}">
                                    <li class="paging-item active"><a href="#">${index}</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li class="paging-item"><a href="#">${index}</a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </ul>

                    <form id="form-nhanvien" class="hidden">
                        <h3>Nhân Viên</h3>
                        <div class="form-group">
                            <label for="tennv">Tên Nhân Viên : </label>
                            <input class="form-control" name="tenNhanVien" id="tennv"/>
                        </div>
                        <div class="form-group">
                            <label for="email-nv">Email : </label>
                            <input class="form-control" name="email-nv" id="email-nv"/>
                        </div>
                        <div class="form-group">
                            <label for="username">Username : </label>
                            <input class="form-control" name="username" id="username"/>
                        </div>
                        <div class="form-group">
                            <label for="diachi-nv">Địa Chỉ : </label>
                            <input class="form-control" name="diachi-nv" id="diachi-nv"/>
                        </div>
                        <div class="form-group">
                            <label>Chức Vụ : </label>
                            <input type="radio" id="checked-manager" name="chucVu" value="3">Manager
                            <input type="radio" id="checked-admin" name="chucVu" value="2"/>Admin
                            <input type="radio" id="checked-user" name="chucVu" value="1"/>User
                        </div>
                        <button class="btn btn-success" id="btn-capnhat-nv">Updates</button>
                    </form>
                </div>
            </div>
        </div>
        <!--body wrapper end-->
    </div>
    <!--footer section start-->
    <footer>
        <p>&copy 2015 Easy Admin Panel. All Rights Reserved | Design by <a href="https://w3layouts.com/"
                                                                           target="_blank">w3layouts.</a></p>
    </footer>
    <!--footer section end-->

    <!-- main content end-->
</section>

<script src='<c:url value="/resources/js/jquery.nicescroll.js"/> '></script>
<script src='<c:url value="/resources/js/scripts.js"/> '></script>
<!-- Bootstrap Core JavaScript -->
<script src='<c:url value="/resources/js/bootstrap.min.js"/> '></script>
<script src='<c:url value="/resources/js/custom.js"/> '></script>
</body>
</html>
