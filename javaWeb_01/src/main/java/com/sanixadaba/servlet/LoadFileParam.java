package com.sanixadaba.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// 获取文件里的参数,相应到前端
public class LoadFileParam extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        // 响应html格式
        resp.setContentType("text/html");
        // 获取上下文再获取流
        InputStream ioS = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
        Properties prop = new Properties();
        // 加载
        prop.load(ioS);
        // 读取
        String username =prop.getProperty("username");
        String pwd =prop.getProperty("password");
        resp.getWriter().print(username+"\t"+pwd);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}