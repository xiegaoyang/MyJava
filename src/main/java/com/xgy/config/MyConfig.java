package com.xgy.config;

/**
 * Created by Administrator on 2016/12/1.
 */


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class MyConfig {
    public static void main(String args[]) {

        // 生成文件对象  
        //File pf = new File(System.getProperty("user.dir")  + "/src/main/java/com/xgy/config/config.properties");
        File pf = new File("F:/code/MyGitProject/xiegy/MyJava/MyJavaIdeaMaven/src/main/java/com/xgy/config/config.properties");

        // 生成文件输入流
        FileInputStream inpf = null;
        try {
            inpf = new FileInputStream(pf);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 生成properties对象  
        Properties p = new Properties();
        try {
            p.load(inpf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 输出properties文件的内容  
        System.out.println("name:" + p.getProperty("name"));
        System.out.println("password:" + p.getProperty("password"));
    }
}  
