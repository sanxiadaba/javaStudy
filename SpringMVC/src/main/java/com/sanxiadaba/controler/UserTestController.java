package com.sanxiadaba.controler;

import com.sanxiadaba.dao.UserTestMapper;
import com.sanxiadaba.pojo.UserTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserTestController {

    //    controller层调用service层
    @Autowired
    @Qualifier("userTestImpl")
    private UserTestMapper userTestMapper;

    //    查询全部书籍页面
    @RequestMapping("/allBook")
    public String allBook(Model model) {
        List<UserTest> list = userTestMapper.selectAll();
        model.addAttribute("list", list);
        return "allBook";
    }
}
