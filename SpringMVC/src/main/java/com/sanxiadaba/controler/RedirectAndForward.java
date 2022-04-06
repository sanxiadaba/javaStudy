package com.sanxiadaba.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectAndForward {

//    转发不会改变url 重定向会

    // 默认是转发
    @GetMapping("/testForward")
    public String testForward(Model model){
        model.addAttribute("msg","这是转发请求");
        // 在已经配置前后缀的情况下,此时不用在前面声明forward 否则反而会报错
        return "test";
    }


    // 测试重定向
    @GetMapping("/testRedirect")
    public String testRedirect(){
        System.out.println("页面已经重定向了");
        return "redirect:http://www.baidu.com";
    }

}
