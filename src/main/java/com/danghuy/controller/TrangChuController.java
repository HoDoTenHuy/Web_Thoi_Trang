package com.danghuy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TrangChuController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView viewTrangChu(ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("trangchu");
        return modelAndView;
    }

    @RequestMapping(path = "/login{id}", method = RequestMethod.GET)
    public String pageLogin(@PathVariable(value = "id") int id,
                            ModelMap modelMap) {
        modelMap.addAttribute("id", id);
        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String pageLoginPOST(@RequestParam(value = "name") String name,
                                ModelMap modelMap) {
        modelMap.addAttribute("name", name);
        return "login";
    }
}
