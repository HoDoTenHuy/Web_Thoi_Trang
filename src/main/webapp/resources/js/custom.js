$(document).ready(function () {
    $("#cot1").click(function () {
        alert("Hahhaa");
        $(this).addClass("adtived-background");
        var text = $(this).attr("data-text");
        alert(text);
    });
    $("#btndangnhap").click(function () {
        var email = $("#username").val();
        var matkhau = $("#password").val();

        $.ajax({
            url : "/api/kiemtradangnhap",
            type : "GET",
            data :{
                username : email,
                password : matkhau
            },
            success : function (value) {
                if(value == "true"){
                    window.location.href = "/";
                }else
                    $("#text-checklogin").text("Đăng Nhập Thất Bại!");
            }
        })
    });
    $("#container-dangky").hide();
    $("#dangnhap").click(function () {
        $("#container-dangky").hide();
        $("#container-dangnhap").show();
        $("#dangky").removeClass("actived");
        $("#dangnhap").addClass("actived");
    });
    $("#dangky").click(function () {
        $("#container-dangky").show();
        $("#container-dangnhap").hide();
        $("#dangnhap").removeClass("actived");
        $("#dangky").addClass("actived");
    });
    $(".btn-giohang").click(function (){
        var tenMau = $(this).closest("tr").find(".mau").text();
        var maMau = $(this).closest("tr").find(".mau").attr("data-mamau");
        var tenSize = $(this).closest("tr").find(".size").text();
        var maSize = $(this).closest("tr").find(".size").attr("data-masize");
        var tensp = $("#tensp").text();
        var giatien = $("#giatien").attr("data-value");
        alert(tensp + giatien + maMau + tenMau + maSize + tenSize);
        /*$.ajax({
            url : "/api/themgiohang",
            type : "GET",
            data :{
                username : email,
                password : matkhau
            },
            success : function (value) {
                if(value == "true"){
                    window.location.href = "/";
                }else
                    $("#text-checklogin").text("Đăng Nhập Thất Bại!");
            }
        })*/
    });
})