package com.danghuy.controller;

import com.danghuy.entity.NhanVienEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


@Controller
public class TrangChuController {
    @RequestMapping("/")
    public String viewTrangChu() {
        ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
        NhanVienEntity nhanVienEntity = (NhanVienEntity) context.getBean("nhanvien");

        CustomLoader customLoader = new CustomLoader();
        customLoader.setResourceLoader(context);
        Resource resource = customLoader.getResource("classpath:data.txt");

        try {
            InputStream inputStream = resource.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = "";
            StringBuilder duLieu = new StringBuilder();
            while((line = bufferedReader.readLine()) != null){
                duLieu.append(line + "\n");
            }
            bufferedReader.close();
            reader.close();
            inputStream.close();
            System.out.println(duLieu.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ((ClassPathXmlApplicationContext) context).close();
        return "trangchu";
    }

    @RequestMapping("/login")
    public String login() {

        return "login";
    }
}
