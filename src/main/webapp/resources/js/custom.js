
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
            }
        })
    });
    $("#btndangky").click(function () {
        var email = $("#email").val();
        var matkhau = $("#matkhau").val();
        var nhaplaimatkhau = $("#nhaplaimatkhau").val();
        $.ajax({
            url : "/api/kiemtradangky",
            type : "GET",
            data :{
                email : email,
                matKhau : "{noop}"+matkhau,
                nhapLaiMatKhau : "{noop}"+nhaplaimatkhau
            },
            success : function (value) {
                if(value == "true"){
                    window.location.href = "/login";
                }else{
                    $("#text-checklogin").text(value);
                }
            }
        })
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
        var giamGia = $("#giatien").attr("data-khuyenmai");
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
                maChiTiet : machitiet,
                khuyenMai : giamGia
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
            var giamgia = $(this).attr("data-giamgia");
            giatien = giatien - parseInt(giatien) * parseInt(giamgia) / 100;
            if(soluong > 1){
                giatien = $(this).closest("tr").find(".giatien").attr("data-giatien");
                giatien = giatien - parseInt(giatien) * parseInt(giamgia) / 100;
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
        var giamgia = $(this).closest("tr").find(".giatien").attr("data-giamgia");
        giatien = giatien - parseInt(giatien) * parseInt(giamgia) / 100;
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
    $("body").on("click", ".paging-item", function () {
        var sotrang = $(this).text();
        var nvbatdau = (sotrang - 1)*5; /*limit hiển thi số sp trong 1 trnga là 5*/
        $(".paging-item").removeClass("active");
        $(this).addClass("active");
        $.ajax({
            url : "/api/laynhanvienlimit",
            type : "GET",
            data :{
                nvBatDau : nvbatdau,
            },
            success : function (value) {
                var tbodynhanvien =  $("#table-nhanvien").find("tbody");
                tbodynhanvien.empty();
                tbodynhanvien.append(value);
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
    var maSanPham;
    var maNhanVien;
    var idSanPham;
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
    $("#them-size").click(function(){
        var tensize = $("#tensize").val();
        $.ajax({
            url : "/api/themsizesanpham",
            type : "GET",
            data :{
                tenSize : tensize
            } ,
            success : function (value) {
                window.location.reload();
            }
        })
    });
    $("#them-mau").click(function(){
        var tenmau = $("#tenmau").val();
        $.ajax({
            url : "/api/themmausanpham",
            type : "GET",
            data :{
                tenMau : tenmau
            } ,
            success : function (value) {
                window.location.reload();
            }
        })
    });
    $("#them-danhmuc").click(function(){
        var tendanhmuc = $("#tendanhmuc").val();
        $.ajax({
            url : "/api/themdanhmucsanpham",
            type : "GET",
            data :{
                tenDanhMuc : tendanhmuc
            } ,
            success : function (value) {
                window.location.reload();
            }
        })
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
            type : "GET",
            data :{
                dataJson : JSON.stringify(json)
            } ,
            success : function (value) {
                if(value = "true"){
                    $("#text-result-btn").text("Thêm Sản Phẩm Thành Công!");
                    $("#them-sanpham").hide();
                    $("#btn-thoat").removeClass("hidden");
                }else{
                    $("#text-result-btn").text("Thêm Sản Phẩm Thất Bại!");
                }
            }
        })
    });
    $("#update-sanpham").click(function (event) {
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
        json["maSanPham"] = maSanPham;
        json["chitietsanpham"] = array_chitiet;
        json["hinhSanPham"] = tenhinh;
        $.ajax({
            url : "/api/capnhatsanpham",
            type : "GET",
            data :{
                dataJson : JSON.stringify(json)
            } ,
            success : function (value) {
                if(value = "true"){
                    $("#text-result-btn").text("Updates Thành Công!");
                    $("#update-sanpham").hide();
                    $("#btn-thoat").removeClass("hidden");
                }else{
                    $("#text-result-btn").text("Updates Thất Bại!");
                }
            }
        })
    });

    $("#btn-thoat").click(function () {
        $("#them-sanpham").removeClass("hidden");
        $("#update-sanpham").addClass("hidden");
        $("#btn-thoat").addClass("hidden");
        window.location.href = "/themsanpham";
    });

    $("body").on("click", ".capnhat-sanpham", function () {
        $("#update-sanpham").removeClass("hidden");
        $("#btn-thoat").removeClass("hidden");
        $("#them-sanpham").addClass("hidden");
        maSanPham = $(this).attr("data-id");
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
                    if(i < value.chiTietSanPhams.length-1){
                        chitiet_clone.find(".btn-chitiet").remove();
                    }
                    $("#container-chitiet-sanpham").append(chitiet_clone);
                }
                if(soLuongChiTiet === 0){
                    $(".btn-chitiet").show();
                }
            }
        })
    });
    $("body").on("click", ".capnhat-nhanvien", function () {
        $("#form-nhanvien").removeClass("hidden");
        maNhanVien = $(this).attr("data-btn-manv");
        $.ajax({
            url : "/api/laynhanvientheoid",
            type : "GET",
            data :{
                idNhanVien : maNhanVien
            } ,
            success : function (value) {
                $("#tennv").val(value.hoTen);
                $("#email-nv").val(value.email);
                $("#username").val(value.tenDangNhap);
                $("#diachi-nv").val(value.diaChi);

                if(value.chucVuEntities[0].name === "ROLE_MANAGER"){
                    $("#checked-manager").prop("checked", true);
                }else if(value.chucVuEntities[0].name === "ROLE_ADMIN"){
                    $("#checked-admin").prop("checked", true);
                }else{
                    $("#checked-user").prop("checked", true);
                }
            }
        })
    });
    $("#btn-capnhat-nv").click(function (event) {
        event.preventDefault(); /*Ngăn chặn reload page*/
        var form_data_nhanvien = $("#form-nhanvien").serializeArray();
        json = {};
        $.each(form_data_nhanvien, function(i, field){
            json[field.name] = field.value;
        });
        json["idNhanVien"] = maNhanVien;
        $.ajax({
            url : "/api/capnhatnhanvien",
            type : "GET",
            data :{
                dataJson : JSON.stringify(json)
            } ,
            success : function (value) {
                if(value = "true"){
                    window.location.reload();
                }
            }
        })
    });
    $("#form-thanhtoan").on("submit",function (e) {
        e.preventDefault();
        var idSanPham = $(this).closest(".row").find(".tensp").attr("data-masp");
        var tenSanPham = $(this).closest(".row").find("#tenKhachHang").val();
        var giaTien = $(this).closest(".row").find(".giatien").attr("data-giatien");
        var giamgia = $(this).closest(".row").find(".giatien").attr("data-giamgia");
        var tongTien = $(this).closest(".row").find("#tongtien").val();
        var soLuong = $(this).closest(".row").find('input[class="soluong-giohang"]').val();
        var diaChi = $(this).closest(".row").find("#diaChiGiaoHang").val();
        var soDienThoai = $(this).closest(".row").find("#soDienThoai").val();
        var tenKhachHang = $(this).closest(".row").find("#tenKhachHang").val();
        var hinhThucGiaoHang = $(this).closest(".row").find('input[name="hinhThucGiaoHang"]:checked').val();
        var ghiChu = $(this).closest(".row").find("#ghiChu").val();
        var email_nhanhang = $(this).closest(".row").find("#email-nhanhang").val();
        $.ajax({
            url : "/api/dathang",
            type : "GET",
            data :{
                    tenKhachHang : tenKhachHang,
                    email : email_nhanhang,
                    soDienThoai : soDienThoai,
                    diaChiGiaoHang : diaChi,
                    hinhThucGiaoHang : hinhThucGiaoHang,
                    ghiChu : ghiChu
            } ,
            success : function (value) {
                if(value === "true"){
                    swal("Đặt Hàng Thành Công!", "Bạn sẽ sớm nhận được hàng!", "success");
                }else{
                    swal("Đặt Hàng Thất Bại!", "Bạn hãy điền đúng và đủ các thông tin!", "error");
                }
                setTimeout(function () {
                    window.location.reload();
                }, 1300);
            }
        })
    });
    $(".btn-duyetdon").click(function () {
        var tinhTrang = $(this).closest("tr").find(".tinhtrang").attr("data-tinhtrang");
        var idhoadon = $(this).closest("tr").find(".idhoadon").text();
        var email = $(this).closest("tr").find(".tenKH").attr("data-email");
        alert(email);
        $.ajax({
            url : "/api/duyetdon",
            type : "GET",
            data :{
                idHoaDon : idhoadon,
                tinhTrang : tinhTrang
            } ,
            success : function (value) {
                if(value === "true"){
                    $("#hoadon").remove();
                    window.location.reload();
                }
            }
        }).done(function () {
            $.ajax({
                url : "/api/sendmessagetoclient",
                type : "GET",
                data :{
                    email : email
                },
                success : function (value) {
                }
            })
        })
    });
    $("#btn-gopy").click(function () {
        var email = $("#email-gopy").val();
        var noidung = $("#noidung-gopy").val();
        $.ajax({
            url : "/api/gopy",
            type : "GET",
            data :{
                email : email,
                noiDung : noidung
            } ,
            success : function (value) {
                $("#email-gopy").val('');
                $("#noidung-gopy").val('');
            }
        })
    });
});