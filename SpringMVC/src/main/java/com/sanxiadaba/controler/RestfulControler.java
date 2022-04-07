package com.sanxiadaba.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RestfulControler {

    @GetMapping("/testAdd/{a}/{b}")
    public String testAdd(@PathVariable int a,@PathVariable int b, Model model){
        int res=a+b;
        model.addAttribute("msg","结果为: "+res);
        return "testMsg";
    }
}
