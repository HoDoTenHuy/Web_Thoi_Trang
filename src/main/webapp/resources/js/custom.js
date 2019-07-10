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
        var masp = $("#tensp").attr("data-masp");
        var giatien = $("#giatien").attr("data-value");
        var soluong = $(this).closest("tr").find(".soluong").attr("data-soluong");
        $.ajax({
            url : "/api/themgiohang",
            type : "GET",
            data :{
                maSP : masp,
                maMau : maMau,
                maSize : maSize,
                soLuong : soluong,
                tenSP : tensp,
                giaTien : giatien,
                tenMau : tenMau,
                tenSize : tenSize
            },
            success : function (value) {
            }
        }).done(function () {
            $.ajax({
                url : "/api/laysoluonggiohang",
                type : "GET",
                success : function (value) {
                    $("#giohang").find("div").addClass("circle-giohang");
                    $("#giohang").find("div").html("<span>" + value + "</span>");
                }
            })
        })
    });
})