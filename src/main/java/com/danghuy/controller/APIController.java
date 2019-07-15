package com.danghuy.controller;

import com.danghuy.entity.*;
import com.danghuy.service.impl.NhanVienServiceImpl;
import com.danghuy.service.impl.SanPhamServiceImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("api/")
@SessionAttributes("user, cart")
public class APIController {
    private final NhanVienServiceImpl nhanVienServiceImpl;
    private final SanPhamServiceImpl sanPhamService;

    @Autowired
    public APIController(NhanVienServiceImpl nhanVienServiceImpl, SanPhamServiceImpl sanPhamService) {
        this.nhanVienServiceImpl = nhanVienServiceImpl;
        this.sanPhamService = sanPhamService;
    }

    @Autowired
    ServletContext context;

    @GetMapping("kiemtradangnhap")
    @ResponseBody
    @Transactional
    public String kiemTraDangNhap(@RequestParam String username, @RequestParam String password, ModelMap modelMap) {
        boolean kiemTra = nhanVienServiceImpl.xuLyDangNhap(username, password);
        modelMap.addAttribute("user", username);
        return kiemTra + "";
    }

    @GetMapping("themgiohang")
    @ResponseBody
    public void themGioHang(@RequestParam int maSP, @RequestParam int maMau,
                            @RequestParam int maSize, @RequestParam int soLuong, @RequestParam String tenSP,
                            @RequestParam String giaTien, @RequestParam String tenMau, @RequestParam String tenSize,
                            @RequestParam int maChiTiet, ModelMap modelMap, HttpSession httpSession) {
        if (httpSession.getAttribute("cart") == null) {
            List<GioHang> gioHangs = new ArrayList<GioHang>();
            GioHang gioHang = new GioHang(maSP, maMau, maSize, 1, maChiTiet, tenSP, giaTien, tenMau, tenSize);
            gioHangs.add(gioHang);
            httpSession.setAttribute("cart", gioHangs);
        } else {
            List<GioHang> list = (List<GioHang>) httpSession.getAttribute("cart");
            int viTri = kiemTraSanPhamGioHang(maSP, maSize, maMau, httpSession);
            if (viTri == -1) {

                GioHang gioHang = new GioHang(maSP, maMau, maSize, 1,
                        maChiTiet, tenSP, giaTien, tenMau, tenSize);
                list.add(gioHang);
            } else {
                int soLuongMoi = list.get(viTri).getSoLuong() + 1;
                list.get(viTri).setSoLuong(soLuongMoi);
            }
        }

    }

    @GetMapping("laysoluonggiohang")
    @ResponseBody
    public String laySoLuongGioHang(HttpSession httpSession) {
        if (httpSession.getAttribute("cart") != null) {
            List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("cart");
            int soSanPham = gioHangs.size();
            return soSanPham + "";
        }
        return "";
    }

    @GetMapping("xoagiohang")
    @ResponseBody
    public void xoaGioHang(HttpSession httpSession, @RequestParam int maSP, @RequestParam int maMau,
                           @RequestParam int maSize) {
        if (httpSession.getAttribute("cart") != null) {
            List<GioHang> list = (List<GioHang>) httpSession.getAttribute("cart");
            int viTri = kiemTraSanPhamGioHang(maSP, maSize, maMau, httpSession);
            list.remove(viTri);
        }
    }

    @GetMapping("capnhatgiohang")
    @ResponseBody
    public void capNhatGioHang(HttpSession httpSession, @RequestParam int maSP, @RequestParam int maMau,
                               @RequestParam int maSize, @RequestParam int soLuong) {
        if (httpSession.getAttribute("cart") != null) {
            List<GioHang> list = (List<GioHang>) httpSession.getAttribute("cart");
            int viTri = kiemTraSanPhamGioHang(maSP, maSize, maMau, httpSession);
            list.get(viTri).setSoLuong(soLuong);
        }
    }
    @GetMapping(path = "laysanphamlimit", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String laySanPhamLimit(@RequestParam int spBatDau){
        String html = "";
        List<SanPhamEntity> sanPhamEntities = sanPhamService.laySanPhamLimit(spBatDau, 5);
        for(SanPhamEntity sp : sanPhamEntities){
            html += "<tr>";
            html += " <td>\n" +
                    "    <div>\n" +
                    "       <input class=\"checkbox-sanpham\" type=\"checkbox\" value=\""+ sp.getIdSanPham() +"\">\n" +
                    "    </div>\n" +
                    " </td>";
            html += " <td class=\"tensp\" data-masp=\" "+ sp.getIdSanPham() +"\">"+ sp.getTenSanPham() +"</td>\n" +
                    " <td class=\"giatien\" data-giatien=\""+ sp.getGiaTien() +"\">"+ sp.getGiaTien() +"</td>\n" +
                    " <td class=\"giatie\" data-masize=\""+ sp.getGianhCho() +"\">"+ sp.getGianhCho() +"</td>";

            html += "</tr>";
        }
        return html;
    }

    @GetMapping("xoasanpham")
    @ResponseBody
    public void xoaSanPhamTheoID(@RequestParam int maSanPham){
        sanPhamService.xoaSanPhamTheoID(maSanPham);
    }

    @PostMapping("uploadfile")
    @ResponseBody
    public void uploadFile(MultipartHttpServletRequest request){
        String pathSaveFile = context.getRealPath("/resources/images/sanpham/");
        Iterator<String> listNames = request.getFileNames();
        MultipartFile multipartFile = request.getFile(listNames.next());
        File fileSave = new File(pathSaveFile + multipartFile.getOriginalFilename());
        try {
            multipartFile.transferTo(fileSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(pathSaveFile);
    }

    @PostMapping("themsanpham")
    @ResponseBody
    public void themSanPham(@RequestParam String dataJson){
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonObject;
        try {
            SanPhamEntity sanPham = new SanPhamEntity();
            jsonObject = objectMapper.readTree(dataJson);

            DanhMucSanPhamEntity danhMucSanPham = new DanhMucSanPhamEntity();
            danhMucSanPham.setIdDanhMuc(jsonObject.get("danhMucSanPhamEntity").asInt());

            Set<ChiTietSanPhamEntity> chiTietSanPhamEntities = new HashSet<ChiTietSanPhamEntity>();
            JsonNode jsonChiTiet = jsonObject.get("chitietsanpham");
            for(JsonNode value : jsonChiTiet){
                ChiTietSanPhamEntity chiTietSanPhamEntity = new ChiTietSanPhamEntity();

                MauSanPhamEntity mauSanPhamEntity = new MauSanPhamEntity();
                mauSanPhamEntity.setIdMau(value.get("idmau").asInt());

                SizeSanPhamEntity sizeSanPhamEntity = new SizeSanPhamEntity();
                sizeSanPhamEntity.setIdSize(value.get("idsize").asInt());

                chiTietSanPhamEntity.setMauSanPhamEntity(mauSanPhamEntity);
                chiTietSanPhamEntity.setSizeSanPhamEntity(sizeSanPhamEntity);
                chiTietSanPhamEntity.setSoLuong(value.get("soluong").asInt());

                chiTietSanPhamEntities.add(chiTietSanPhamEntity);
            }
            String tenSanPham = jsonObject.get("tenSanPham").asText();
            String moTa = jsonObject.get("moTa").asText();
            String hinhSanPham = jsonObject.get("hinhSanPham").asText();
            String gianhCho = jsonObject.get("gianhCho").asText();
            String giaTien = jsonObject.get("giaTien").asText();

            sanPham.setChiTietSanPhamEntities(chiTietSanPhamEntities);
            sanPham.setDanhMucSanPhamEntity(danhMucSanPham);
            sanPham.setTenSanPham(tenSanPham);
            sanPham.setGiaTien(giaTien);
            sanPham.setMoTa(moTa);
            sanPham.setHinhSanPham(hinhSanPham);
            sanPham.setGianhCho(gianhCho);

            sanPhamService.themSanPham(sanPham);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private int kiemTraSanPhamGioHang(int maSP, int maSize, int maMau, HttpSession httpSession) {
        List<GioHang> list = (List<GioHang>) httpSession.getAttribute("cart");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaSP() == maSP && list.get(i).getMaMau() == maMau && list.get(i).getMaSize() == maSize) {
                return i;
            }
        }
        return -1;
    }
}
