package com.sanixadaba.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

// 学习cookies
public class useCookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        // 一个输出流的对象
        PrintWriter out = resp.getWriter();
        // 获取cookies
        Cookie[] cookies = req.getCookies();
        // 判断cookies是否存在
        boolean flag=false;
        try {
            // 如果存在cookies,输出上一次登陆的时间
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("lastLoginTime")){
                    // 获取cookies的键值对
                    long lastLoginTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastLoginTime);
//                    out.write(date.toString());
                      out.write(date.toLocaleString());
                    flag=true;
                }
            }

        }finally {
            if(!flag){
                out.write("这是你第一次登陆");

            }
        }
        // 给客户端相应一个cookies
        Cookie cookie = new Cookie("lastLoginTime",System.currentTimeMillis()+"");
        // 设置cookies的有效期 // 设置为0的话让其立即失效
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
