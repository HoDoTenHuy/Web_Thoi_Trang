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
    $("#check-all-sanpham").change(function () {
        var checkboxes = $(this).closest('table').find('.checkbox-sanpham');
        checkboxes.prop('checked', $(this).is(':checked'));
    });
    $("#xoa-sanpham").click(function () {
        $("#table-sanpham > tbody input:checked").each(function () {
           var masanpham = $(this).val();
           var hangcanxoa = $(this);
            $.ajax({
                url : "/api/xoasanpham",
                type : "GET",
                data :{
                    maSanPham : masanpham,
                },
                success : function (value) {
                    hangcanxoa.closest("tr").remove();
                }
            })
        });
    });
    var files = [];
    var tenhinh = "";
    $("#hinhanh").change(function (event) {
        files = event.target.files;
        tenhinh = files[0].name;
        forms = new FormData();
        forms.append("file", files[0]);
        $.ajax({
            url : "/api/uploadfile",
            type : "POST",
            data :forms ,
            contentType :false ,
            processData : false ,
            enctype : "multipart/form-data",
            success : function (value) {

            }
        })
    });
    $("body").on("click", ".btn-chitiet", function () {
        $(this).remove();
       var chitiet_clone = $("#chitiet-sanpham").clone();
       chitiet_clone.removeAttr("id");
       $("#container-chitiet-sanpham").append(chitiet_clone);
    });
    $("#them-sanpham").click(function (event) {
        event.preventDefault(); /*Ngăn chặn reload page*/
        var form_data_sanpham = $("#form-sanpham").serializeArray();
        json = {};
        $.each(form_data_sanpham, function(i, field){
            json[field.name] = field.value;
        });

        /*console.log(array_chitiet);*/
        object_chitiet = {};
        array_chitiet = [];
        $("#container-chitiet-sanpham > .chitiet-sanpham").each(function () {
            var idmau = $(this).find('select[name="chitietmau"]').val();
            var idsize = $(this).find('select[name="danhmucsize"]').val();
            var soluong = $(this).find('input[name="soluong"]').val();
            object_chitiet["idmau"] = idmau;
            object_chitiet["idsize"] = idsize;
            object_chitiet["soluong"] = soluong;

            array_chitiet.push(object_chitiet);
            object_chitiet = {};
        });

        json["chitietsanpham"] = array_chitiet;
        json["hinhSanPham"] = tenhinh;

        $.ajax({
            url : "/api/themsanpham",
            type : "POST",
            data :{
                dataJson : JSON.stringify(json)
            } ,
            success : function (value) {

            }
        })
    });
    $("body").on("click", ".capnhat-sanpham", function () {
        var maSanPham = $(this).attr("data-id");
        $.ajax({
            url : "/api/laydanhsachsanphamtheoid",
            type : "GET",
            data :{
                idSanPham : maSanPham
            } ,
            success : function (value) {
                console.log(value);
                $("#tensp").val(value.tenSanPham);
                $("#giasp").val(value.giaTien);
                $("#motasp").val(value.moTa);
                if(value.gianhCho === "Nam"){
                    $("#checked-nam").prop("checked", true);
                }else{
                    $("#checked-nu").prop("checked", true);
                }
                $("#danhmucsanpham").val(value.danhMucSanPham.idDanhMuc);

                $("#container-chitiet-sanpham").empty();
                for(i=0; i < value.chiTietSanPhams.length; i++){
                    var chitiet_clone = $("#chitiet-sanpham").clone().removeAttr("id");
                    chitiet_clone.find("#mamau-sanpham").val(value.chiTietSanPhams[i].mauSanPhamEntity.idMau);
                    chitiet_clone.find("#masize-sanpham").val(value.chiTietSanPhams[i].sizeSanPhamEntity.idSize);
                    chitiet_clone.find("#soluong-sanpham").val(value.chiTietSanPhams[i].soLuong);

                    $("#container-chitiet-sanpham").append(chitiet_clone);
                }
            }
        })
    });
});