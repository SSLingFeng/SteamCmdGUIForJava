package ui;

import service.I18nUtil;

import javax.swing.*;
import java.awt.*;

public class PageMenu extends JFrame {
    public PageMenu() {
        PageMenuShow();
    }

    public static void main(String[] args) {
        new PageMenu().setVisible(true);
    }

    public void PageMenuShow() {

        //创建tabcard
        JTabbedPane mainTabbedPane =new JTabbedPane();

        JPanel tabPanelA= new JPanel();
        JPanel tabPanelB= new JPanel();
        mainTabbedPane.addTab(I18nUtil.getMessage("tableTitleA"), tabPanelA);
        mainTabbedPane.addTab(I18nUtil.getMessage("tableTitleB"), tabPanelB);


        JTextField cmdPath = new JTextField();//steamCMd路径
        cmdPath.setEnabled(false);
















        //获取电脑屏幕宽高，设置窗体居中显示
        Toolkit a1 = Toolkit.getDefaultToolkit();
        int a1he = a1.getScreenSize().height;
        int a1wh = a1.getScreenSize().width;
        a1he = a1he / 2 - 200;
        a1wh = a1wh / 2 - 400;
        this.add(mainTabbedPane);
        this.setBounds(a1wh, a1he, 800, 300);
        this.setVisible(true);//显示窗体
        this.setTitle(I18nUtil.getMessage("title"));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭方式
        this.setResizable(false);//禁止拉动边框，禁止最大化
        this.setBackground(Color.BLACK);//设置窗体背景颜色
    }

}
