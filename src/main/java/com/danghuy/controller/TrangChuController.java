package com.danghuy.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class TrangChuController {

    @GetMapping
    @Transactional
    public String pageDefault(ModelMap modelMap, HttpSession httpSession){
        if(httpSession.getAttribute("user") != null){
            String email = (String) httpSession.getAttribute("user");
            String chuCaiDau = email.substring(0 , 1).toUpperCase();
            modelMap.addAttribute("chuCaiDau", chuCaiDau);

        }

        return "trangchu";
    }


}
