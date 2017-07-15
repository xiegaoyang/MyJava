package com.xgy.io;

import java.io.File;

/**
 * Created by hadoop on 2017/7/14.
 */
public class FileBianLi {

    public static void test() {
        File f = new File("/Users/Hao/Downloads");
        for (File temp : f.listFiles()) {
            if (temp.isFile()) {
                System.out.println(temp.getName());
            }
        }
    }

    public static void main(String[] args) {
        showDirectory(new File("/Users/Hao/Downloads"));
    }

    public static void showDirectory(File f) {
        _walkDirectory(f, 0);
    }

    private static void _walkDirectory(File f, int level) {
        if (f.isDirectory()) {
            for (File temp : f.listFiles()) {
                _walkDirectory(temp, level + 1);
            }
        } else {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("\t");
            }
            System.out.println(f.getName());
        }
    }

}
