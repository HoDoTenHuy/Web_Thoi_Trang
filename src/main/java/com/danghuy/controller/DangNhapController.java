package com.danghuy.controller;

import com.danghuy.commons.CheckEmail;
import com.danghuy.pojo.GooglePojo;
import com.danghuy.pojo.NhanVien;
import com.danghuy.service.impl.NhanVienServiceImpl;
import com.danghuy.utils.GoogleUtils;
import com.danghuy.utils.RestFB;
import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@SessionAttributes({"google", "facebook"})
public class DangNhapController {
    @Autowired
    private GoogleUtils googleUtils;

    @Autowired
    private RestFB restFB;

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

    @RequestMapping("/login-google")
    public String loginGoogle(HttpServletRequest request, ModelMap modelMap) throws ClientProtocolException, IOException{
        String code = request.getParameter("code");

        if(code == null || code.isEmpty()){
            return "redirect:/login?message=google_error";
        }
        String accessToken = googleUtils.getToken(code);

        GooglePojo googlePojo = googleUtils.getUserInfo(accessToken);
        UserDetails userDetail = googleUtils.buildUser(googlePojo);
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        modelMap.addAttribute("google", googlePojo);
        return "redirect:/";
    }

    @RequestMapping("/login-facebook")
    public String loginFacebook(HttpServletRequest request, ModelMap modelMap) {
        String code = request.getParameter("code");
        String accessToken = "";
        try {
            accessToken = restFB.getToken(code);
        } catch (IOException e) {
            return "login?facebook=error";
        }
        com.restfb.types.User user = restFB.getUserInfo(accessToken);
        UserDetails userDetail = restFB.buildUser(user);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
                userDetail.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        modelMap.addAttribute("facebook", user);
        System.out.println(user.getPicture() + "-" + user.getEmail());
        return "redirect:/";
    }
}
