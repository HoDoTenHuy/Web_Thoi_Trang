package com.danghuy.controller;

import com.danghuy.entity.NhanVienEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TrangChuController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView viewTrangChu(ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("trangchu");



        return modelAndView;
    }

    @RequestMapping(path = "/login/{id}/{tensp}", method = RequestMethod.GET)
    public String pageLogin(@PathVariable("id") int id, @PathVariable("tensp") String tenSP,
                            ModelMap modelMap){
        modelMap.addAttribute("id", id);
        modelMap.addAttribute("tensp", tenSP);
        return "login";
    }
}
