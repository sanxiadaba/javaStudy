package com.sanxiadaba.controler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sanxiadaba.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

// 这个注解表示下面的方法只会返回字符串
@RestController
public class TestJsonController {

    //    返回一个字符串
    @RequestMapping("/testJson")
//  @ResponseBody  // 阻止视图解析器
    public String testJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        // 取消默认转换成时间戳
        mapper.configure(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS, false);
        //        格式化时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(dateFormat);
        User user1 = new User("小明1号", 1);
        User user2 = new User("小明2号", 2);
        User user3 = new User("小明3号", 3);
        User user4 = new User("小明4号", 4);
        ArrayList<User> userArrayList = new ArrayList<>();
        userArrayList.add(user1);
        userArrayList.add(user2);
        userArrayList.add(user3);
        userArrayList.add(user4);
        Date date = new Date();

//        return mapper.writeValueAsString(user1); //  {"name":"小明1号","age":1}
//        return mapper.writeValueAsString(userArrayList); //  [{"name":"小明1号","age":1},{"name":"小明2号","age":2},{"name":"小明3号","age":3},{"name":"小明4号","age":4}]
//        return mapper.writeValueAsString(date); // 1649336696229  // 不配置jackson时间戳的情况下
//        return dateFormat.format(date);
        return mapper.writeValueAsString(date); //"2022-04-07 21:11:52"
    }

}
