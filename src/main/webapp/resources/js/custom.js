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
})