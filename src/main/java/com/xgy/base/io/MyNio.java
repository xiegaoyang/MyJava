package com.xgy.base.io;

/**
 * Created by gowild.cn on 2017/7/12.
 */
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MyNio {
    public static void main(String[] args) throws Exception {
        FileInputStream fin = new FileInputStream(new File("d:/1.txt"));
        FileChannel fc = fin.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        fc.read(byteBuffer);
        fc.close();
        byteBuffer.flip();//读写转换
        System.out.println(byteBuffer.array().toString());
    }
}
