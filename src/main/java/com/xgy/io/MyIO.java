package com.xgy.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyIO {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TestIO1();
    }

    public static void TestFile() {
        File file = new File(".");
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsoluteFile().getParent());

    }

    public static void TestSerializable() {


    }

    public static void TestIO1() {

        String s = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            s = br.readLine();
            System.out.println("s = " + Integer.parseInt(s));
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println(" error ");
        } finally {
            if (null != br) {
                try {
                    br.close();
                    br = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
