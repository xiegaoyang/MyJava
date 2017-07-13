package com.xgy.base.io;

import java.io.*;

public class MyFile2 {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        CopyFile("1.txt", "2.txt");

        // FileOutputStream out = new FileOutputStream("hello.txt");
        // out.write("www.sina.com.cn".getBytes()); // ���ַ���ת��Ϊ�ֽ����鲢д�뵽����
        // out.close();
        // byte[] buf = new byte[1024];
        // File f = new File("hello.txt");
        // FileInputStream in = new FileInputStream(f);
        // int len = in.read(buf); // ��ȡ���ݵ��ֽ�������
        // System.out.println(new String(buf, 0, len)); // String���캯�����ֽ�����ת��Ϊ�ַ���
        // in.close();

        FileWriter out = new FileWriter("hello2.txt");
        out.write("www.sina.com.cn"); // �ڴ˿���ֱ��д���ַ���������ת��Ϊ�ֽ�����
        out.close();

        char[] buf = new char[1024]; // �ַ�����
        FileReader in = new FileReader("hello2.txt");
        int len = in.read(buf); // ��ʱ��read�������Զ�ȡһ���ַ��򼸸��ַ�,len����ʵ�ʶ�ȡ�����ַ��ĸ�����
        System.out.println(new String(buf, 0, 1024)); // String���캯�����ַ�����ת��Ϊ�ַ�����
        in.close();

    }

    public static void CopyFile(String oldFileName, String newFileName) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldFile = new File(oldFileName);
            if (oldFile.exists()) {
                InputStream inStream = new FileInputStream(oldFileName);
                OutputStream outStream = new FileOutputStream(newFileName);
                byte[] buffer = new byte[1024];
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread;
                    System.out.println(bytesum);
                    // System.out.println(buffer.toString());
                    System.out.println(new String(buffer));
                    outStream.write(buffer);
                }
                inStream.close();
                outStream.close();
            }
        } catch (Exception e) {
            System.out.println("failed");
            e.printStackTrace();
        }

    }

}
