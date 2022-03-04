package com.sanixadaba.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
// 下载文件
public class DownFile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取下载文件的路径
        String realPath="D:\\Code\\Java\\MVN\\javaWeb_01\\src\\main\\resources\\girl.jpg";
        // 下载文件的名称
        String fileName=realPath.substring(realPath.lastIndexOf("\\")+1);
        // 设置浏览器能支持我们下载的东西(注意编码格式)
        resp.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(fileName,"UTF-8"));
        // 获取下载文件的输出流
        FileInputStream in = new FileInputStream(realPath);
        // 创建缓冲区
        int len=0;
        byte[] buffer=new byte[1024];
        // 获取输出流对象
        ServletOutputStream out = resp.getOutputStream();
        // 将文件写到缓冲区并发送到客户端
        while ((len=in.read(buffer))>0){
            out.write(buffer,0,len);
        }
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
