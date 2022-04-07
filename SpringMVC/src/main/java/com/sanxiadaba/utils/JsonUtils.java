package com.sanxiadaba.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

// 对格式化字符串进行一次封装
public class JsonUtils {
    public static String getJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        // 取消默认转换成时间戳
        mapper.configure(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS, false);
        //        格式化时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(dateFormat);
        return mapper.writeValueAsString(obj);
    }
}
