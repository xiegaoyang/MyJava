package com.xgy.io;

import java.io.*;

/**
 * Created by Administrator on 2016/11/18.
 */

public class MyFileAsync {

    static String readLineVarFile(String fileName, int lineNumber) throws IOException {

        if (lineNumber < 0 || lineNumber > getTotalLines(fileName)) {
            System.out.println("不在文件的行数范围之内。");
            return "";
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        String line = "";
        int num = 0;

        do {
            line = reader.readLine();
        } while (lineNumber != ++num);

        reader.close();

        return line;
    }

    // 文件内容的总行数。    
    static int getTotalLines(String fileName) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        LineNumberReader reader = new LineNumberReader(in);
        String s = reader.readLine();
        int lines = 0;
        while (s != null) {
            lines++;
            s = reader.readLine();
        }
        reader.close();
        in.close();
        return lines;
    }

    public static void main(String[] args) throws IOException {

        // 读取文件    
        String fileName = "d:/hst_23.txt";

        // 获取文件的内容的总行数    
        int totalNo = getTotalLines(fileName);
        System.out.println("There are " + totalNo + " lines in the text!");

        // 指定读取的行号    
        int lineNumber = 10;

        //读取指定行的内容 
        readLineVarFile("d:/hst_23.txt", lineNumber);
    }
}
