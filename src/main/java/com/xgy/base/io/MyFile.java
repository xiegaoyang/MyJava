package com.xgy.base.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyFile {

    private File file = null;
    private String fileName = "";

    MyFile() {

    }

    MyFile(String fileName) {
        this.fileName = fileName;
        file = new File(this.fileName);
    }

    public static void main(String[] args) {
        String fileName = "1.txt";
        MyFile myFile = new MyFile(fileName);
        if (!myFile.getFile().exists()) {
            myFile.createFile();
        }
        if (!myFile.openFile("r")) {
            System.out.println(fileName + " open failed");
            return;
        }


        int size = myFile.getFileSize();
        System.out.println("size = " + size);
        try {
            System.out.println(myFile.readLastNLine(3));
        } catch (IOException e) {
            e.printStackTrace();
        }


        //TestFile();
    }

    public static void TestFile() {

        System.out.println("enter......");

        File file = new File("D:" + File.separator + "test.txt");
        //File file = new File("D:/test.txt" );
        try {
            System.out.println("path : " + file.getCanonicalPath());
            System.out.println("filename : " + file.getName());
            if (file.exists()) {
                if (file.isFile()) {
                    System.out.println("is file");
                    if (file.canWrite()) {
                        System.out.println("can write");
                    }
                    if (file.canRead()) {
                        System.out.println("can read");
                    }
//					if (file.canExecute())
//					{
//						System.out.println("can execute");
//					}
                    file.delete();
                }
            } else {
                file.createNewFile();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean createFile() {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public String readFileContent(String fileName) throws IOException {

        File file = new File(fileName);//读文件

        BufferedReader bf = new BufferedReader(new FileReader(file));

        String content = "";
        StringBuilder sb = new StringBuilder();

        while (content != null) {
            content = bf.readLine();//读每一行

            if (content == null) {//读到null,返回
                break;
            }

            sb.append(content.trim());
        }

        bf.close();//关闭文件
        return sb.toString();
    }

    public boolean openFile(String mode) {

        if (fileName.equals("")) {
            System.out.println("fileName is empty");
            return false;
        }

        if (null == file) {
            file = new File(fileName, mode);
            if (!file.exists()) {
                System.out.println(fileName + " is not exist");
                return false;
            }
        }

        return true;
    }

    public boolean closeFile() {

        return true;
    }

    public int getFileSize() {
        return (int) file.length();
    }

    public int getFileLineSize() {
        return 0;
    }

    public String getOneLine(int number) {
        return "";
    }

    public List<String> getSomeLines(int start, int size) {
        List<String> lines = new ArrayList<String>();
        return lines;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        file = new File(this.fileName);
    }

    public File getFile() {
        return file;
    }

    public String readLastNLine(long numRead) throws IOException {
        String result = "";
        long count = 0;
        if (!file.exists() || file.isDirectory() || !file.canRead()) {
            return null;
        }
        RandomAccessFile fileRead = null;
        try {
            fileRead = new RandomAccessFile(file, "r");
            long length = fileRead.length();
            if (length == 0L) {
                return "";
            }

            long pos = length - 1;
            while (pos > 0) {
                pos--;
                fileRead.seek(pos);
                if (fileRead.readByte() == '\n') {
                    String line = fileRead.readLine();
                    //处理中文的乱码问题(原文件编码格式为utf-8)
                    line = new String(line.getBytes("8859_1"), "utf-8");
                    result = line + "\n" + result;
                    count++;
                    if (count == numRead) {
                        break;
                    }
                }
            }
            if (pos == 0) {
                fileRead.seek(0);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileRead != null) {
                    fileRead.close();
                }
            } catch (Exception e) {
            }
        }

        return result;
    }


}




