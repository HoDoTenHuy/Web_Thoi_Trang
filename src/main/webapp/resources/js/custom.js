$(document).ready(function () {
    $("#cot1").click(function () {
        alert("Hahhaa");
        $(this).addClass("adtived-background");
        var text = $(this).attr("data-text");
        alert(text);
    });
    $(".xoa-giohang").click(function () {
        var maMau = $(this).closest("tr").find(".mau").attr("data-mamau");
        var maSize = $(this).closest("tr").find(".size").attr("data-masize");
        var masp = $(this).closest("tr").find(".tensp").attr("data-masp");
        var self = $(this);
        $.ajax({
            url : "/api/xoagiohang",
            type : "GET",
            data :{
                maSP : masp,
                maMau : maMau,
                maSize : maSize
            },
            success : function (value) {
                self.closest("tr").remove();
                gantongtiengiohang(true);
            }
        })
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
        var machitiet = $(this).attr("data-machitiet");
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
                tenSize : tenSize,
                maChiTiet : machitiet
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

    gantongtiengiohang();
    function gantongtiengiohang(isEventChange){
        var tongtiensp = 0;
        $(".giatien").each(function () {
            var giatien =  $(this).text();
            var soluong = $(this).closest("tr").find(".soluong-giohang").val();
            if(soluong > 1){
                giatien = $(this).closest("tr").find(".giatien").attr("data-giatien");
            }
            var tongtien = parseInt(giatien) * soluong;
            if(!isEventChange){
                $(this).html(tongtien + ".000 VNĐ");
            }
            tongtiensp = tongtiensp + tongtien;
            var formattongtien = tongtiensp.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g,
                "$1.").toString();
            $("#tongtien").html(formattongtien + " VNĐ");
        });
    }
    $(".soluong-giohang").change(function () {
        var soluong = $(this).val();
        var giatien = $(this).closest("tr").find(".giatien").attr("data-giatien");
        var tongtien = soluong * parseInt(giatien);
        var maMau = $(this).closest("tr").find(".mau").attr("data-mamau");
        var maSize = $(this).closest("tr").find(".size").attr("data-masize");
        var masp = $(this).closest("tr").find(".tensp").attr("data-masp");

        $(this).closest("tr").find(".giatien").html(tongtien + ".000 VNĐ");
        gantongtiengiohang(true);

        $.ajax({
            url : "/api/capnhatgiohang",
            type : "GET",
            data :{
                maSP : masp,
                maMau : maMau,
                maSize : maSize,
                soLuong : soluong
            },
            success : function (value) {
            }
        })
    });
    $("body").on("click", ".paging-item", function () {
        var sotrang = $(this).text();
        var spbatdau = (sotrang - 1)*5; /*limit hiển thi số sp trong 1 trnga là 5*/
        $(".paging-item").removeClass("active");
        $(this).addClass("active");
        $.ajax({
            url : "/api/laysanphamlimit",
            type : "GET",
            data :{
                spBatDau : spbatdau,
            },
            success : function (value) {
                var tbodysanpham =  $("#table-sanpham").find("tbody");
                tbodysanpham.empty();
                tbodysanpham.append(value);
            }
        })
    });
});