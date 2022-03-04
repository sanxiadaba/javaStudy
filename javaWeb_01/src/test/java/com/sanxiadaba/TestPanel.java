package com.sanxiadaba;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestPanel {
    public static void main(String[] args) {
        // 新建窗体
        Frame frame=new Frame("这是一个标题");
        // 新建面板(设置布局为null)
        Panel panel = new Panel(null);

        // 设置窗体的布局
        frame.setLayout(null);
        // 设置窗体显示的坐标,窗口的宽高
        frame.setBounds(300,300,500,500);
        // 设置背景颜色
        frame.setBackground(new Color(0,0,255));

        // 设置面板的位置,大小
        panel.setBounds(50,50,300,300);
        // 设置面板的背景颜色
        panel.setBackground(new Color(0,255,0));

        // 将面板添加到主体
        frame.add(panel);
        // 设置面板可见性
        frame.setVisible(true);

        // 监听事件
        frame.addWindowListener(new WindowAdapter() {
            // 窗口打开事件
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("窗口打开");
            }

            // 窗口正在关闭事件
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("窗口关闭ing");
                // 正常终止退出程序 (非正常为1)
                System.exit(0);
            }

            // 窗口关闭事件
            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("窗口关闭");
            }

            // 窗口最大激活事件
            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("窗口最大化");
            }

            // 窗口未被激活事件
            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("窗口未被最大化");
            }
        });
    }

}
