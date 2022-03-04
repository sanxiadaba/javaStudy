package com.sanixadaba.listen;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

// 监听器,查看网站在线人数(通过统计session的数量来达到)
public class OnlineNum implements HttpSessionListener {
    // 创建session监听
    // 一旦创建一个session就会触发这个事件
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // 手动销毁session
        // se.getSession().invalidate();
        ServletContext ctx = se.getSession().getServletContext();
        // 查看创建的sessiion id(明明只有一个人,却有两个session)
        System.out.println(se.getSession().getId());
        Integer onlineCount = (Integer) ctx.getAttribute("onlineCount");
        if (onlineCount==null){
            onlineCount= 1;
        }else {
            int count= onlineCount;
            onlineCount= count + 1;
        }
        ctx.setAttribute("onlineCount",onlineCount);
    }

    // 销毁session监听
    // 一旦销毁一个session就会触发这个事件
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();
        Integer onlineCount = (Integer) ctx.getAttribute("onlineCount");
        if (onlineCount==null){
            onlineCount=new Integer(1);
        }else {
            int count=onlineCount.intValue();
            onlineCount=new Integer(count-1);
        }
        ctx.setAttribute("onlineCount",onlineCount);
    }
}
