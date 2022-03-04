package com.sanixadaba.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

// 加载验证码
public class VerificationCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 让浏览器三秒刷新一次
        resp.setHeader("refresh","3");
        // 在内存中创建一个图片
        BufferedImage codeImage = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
        // 得到图片
        Graphics2D graphics = (Graphics2D) codeImage.getGraphics();
        // 设置图片的背影颜色
        graphics.setColor(Color.white);
        // 设置颜色填充的坐标
        graphics.fillRect(0,0,80,20);
        /*给图片生成随机数*/
        // 设置随机数的颜色
        graphics.setColor(Color.BLUE);
//      // 设置画笔的样式
        graphics.setFont(new Font(null,Font.BOLD,20));
        graphics.drawString(makeNum(),0,20);
        // 告诉浏览器,以图片格式打开
        resp.setContentType("image/jpeg");
        // 网站存在缓存,让浏览器不缓存
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");
        // 把图片传送给浏览器
        ImageIO.write(codeImage,"jpeg",resp.getOutputStream());

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    // 生成随机数
    private String makeNum(){
        Random random = new Random();
        String s = random.nextInt(9999999) + "";
        // 最后输出的字符串
        StringBuilder sb = new StringBuilder();
        // 这个循环用来确保一定输出七位数字
        for (int i = 0; i < 7 - s.length(); i++) {
            sb.append("0");
        }
        s= sb +s;
        return s;
    }


}
