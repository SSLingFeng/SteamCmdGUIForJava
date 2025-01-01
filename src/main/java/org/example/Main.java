package org.example;

import service.Config;
import service.I18nUtil;
import ui.PageMenu;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");

        System.out.println("currentLocale:"+ I18nUtil.getCurrentLocale());
        Config.load();
        new PageMenu();



    }
}