package com.hogan.designmode.factory.entity;

import javax.swing.*;
import java.awt.*;

/**
 * 苹果
 * wujun
 * 2019/12/02 11:16
 */
public class Apple implements Fruit {

    JScrollPane sp;
    JFrame jf = new JFrame("抽象工厂模式测试");

    public Apple() {
        Container contentPane = jf.getContentPane();
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1));
        p1.setBorder(BorderFactory.createTitledBorder("水果：苹果"));
        sp = new JScrollPane(p1);
        contentPane.add(sp, BorderLayout.CENTER);
        JLabel l1 = new JLabel(new ImageIcon("src/images/F_Apple.jpg"));
        p1.add(l1);
        jf.pack();
        jf.setVisible(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//用户点击窗口关闭
    }

    @Override
    public void show() {
        jf.setVisible(true);
    }
}
