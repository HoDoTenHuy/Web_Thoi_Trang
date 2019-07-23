package com.danghuy.controller;

import com.danghuy.commons.CheckEmail;
import com.danghuy.pojo.NhanVien;
import com.danghuy.service.impl.NhanVienServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DangNhapController {
    @RequestMapping(value = "/login")
    public String login(@RequestParam(value = "error", required = false) final String error, final Model model) {
        if (error != null) {
            model.addAttribute("message", "Login Failed!");
        }
        return "login";
    }
    @RequestMapping("/admin")
    public String admin() {
        return "themsanpham";
    }
    @RequestMapping("/manager")
    public String manager() {
        return "dashboard";
    }
    @RequestMapping("/user")
    public String user() {
        return "trangchu";
    }
    @RequestMapping("/logout")
    public String logout(final Model model) {
        model.addAttribute("message", "Logged out!");
        return "login";
    }
}
