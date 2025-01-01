package service;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Objects;

public class Config {

    public HashMap<String, Objects> buffer;

    public static String modulePath;
    public static String configFilePath;
    public static JSONObject configData;


    public static void load() throws IOException {
        modulePath = System.getProperty("user.dir");  //获取模块路径
        configFilePath = modulePath + "/SteamCmdGUIForJavaConfig.json";
//        System.out.println("configFilePath:" + configFilePath);
        File configFile = new File(configFilePath);
        if (configFile.exists()) read();
        else wirte();
    }

    public static void read() {
        configData = JSONUtil.readJSONObject(new File(configFilePath), StandardCharsets.UTF_8);
    }

    public static void wirte() {
        // 将 JSON 数据写入文件
        JSONUtil.toJsonPrettyStr(configData); // 格式化为字符串
        FileUtil.writeUtf8String(JSONUtil.toJsonPrettyStr(configData), new File(configFilePath));
    }

    //设置值
    public static void set(String key, Object obj) {
        configData.set(key, obj);
        wirte();
    }

    //获取key值
    public static Object get(String key) {
        Object obj = configData.get(key);
        return obj;
    }

    public HashMap<String, Objects> getBuffer() {
        return buffer;
    }

    public void setBuffer(HashMap<String, Objects> buffer) {
        this.buffer = buffer;
    }

    public static String getModulePath() {
        return modulePath;
    }

    public static void setModulePath(String modulePath) {
        Config.modulePath = modulePath;
    }

    public static String getConfigFilePath() {
        return configFilePath;
    }

    public static void setConfigFilePath(String configFilePath) {
        Config.configFilePath = configFilePath;
    }

    public static JSONObject getConfigData() {
        return configData;
    }

    public static void setConfigData(JSONObject configData) {
        Config.configData = configData;
    }
}
