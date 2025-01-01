package service;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class I18nUtil {

    private static Locale currentLocale = Locale.getDefault(); // 默认是系统语言

    public static Locale getCurrentLocale() {
        return currentLocale;
    }

    public static void setCurrentLocale(Locale currentLocale) {
        I18nUtil.currentLocale = currentLocale;
    }

    // 设置当前的语言环境
    public static void setLocale(Locale locale) {
        currentLocale = locale;
    }

    // 获取当前语言环境的资源文件
    private static ResourceBundle getBundle() {
        return ResourceBundle.getBundle("messages", currentLocale);
    }

    // 根据key获取对应的国际化文本
    public static String getMessage(String key, Object... params) {
        ResourceBundle bundle = getBundle();
        String message = bundle.getString(key);
        return MessageFormat.format(message, params); // 格式化文本
    }
}
