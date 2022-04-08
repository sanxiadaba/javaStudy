package com.sanxiadaba.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model) {
        String msg = "hello Spring";
        // 封装数据
        model.addAttribute("msg", msg);
        return "testMsg";
    }
}
