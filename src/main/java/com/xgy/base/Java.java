package com.xgy.base;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


public class Java {

    public static void main(String[] args) throws RuntimeException {

        try {

            System.out.println(args.length);

            for (String arg : args) {
                System.out.println(arg);
            }

            for (int i = 0; i < args.length; ++i) {
                System.out.println(args[i]);
            }

            System.out.println("Hello World!");

            //TestDate();
            //TestString();
            // TestScan();

            try {
                TestSystem();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // TestRuntime();
            //TestCollection();
            //TestClass();

        } catch (IndexOutOfBoundsException ie) {
        } catch (ArithmeticException ie) {
        } catch (Exception ie) {
        } finally {
            System.out.println("End");
        }

    }

    public static void TestDate() {
        System.out.println(new Date());

        Calendar ca = Calendar.getInstance();
        Date date1 = ca.getTime();
        System.out.println(date1);

    }

    public static void TestString() {
        String s = "12345, XIE gao Yang";
        System.out.println("s.length = " + s.length());
        System.out.println("low : " + s.toLowerCase());
        System.out.println("up : " + s.toUpperCase());
    }

    public static void TestArray() {
        int[] a = new int[10];
        for (int i = 0; i < a.length; ++i) {
            a[i] = i;
        }
    }

    public static void TestScan() {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");// ʹ�ûس�����Ϊ�ָ���
        System.out.println("������:");
        while (sc.hasNext()) {
            System.out.println("data : " + sc.next());
        }

        sc.close();
    }


    public static void TestSystem() throws FileNotFoundException, IOException {
        Map<String, String> env = System.getenv();

        for (String name : env.keySet()) {
            System.out.println(name + " ---> " + env.get(name));
        }

        System.out.println("\n");

        System.out.println(System.getenv("JAVA_HOME"));
        Properties props = System.getProperties();

        props.store(new FileOutputStream("props.txt"), "System Properties");
        System.out.println(System.getProperty("os.name"));

        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());

        System.gc();
        System.runFinalization();

        System.exit(0);

    }

    public static void TestRuntime() {

        Runtime rt = Runtime.getRuntime();
        int base = 1;// 1024 * 1024;
        System.out.println("���������� :" + rt.availableProcessors());
        System.out.println("�����ڴ���:" + rt.freeMemory() / base);
        System.out.println("���ڴ��� :" + rt.totalMemory() / base);
        System.out.println("��������ڴ��� :" + rt.maxMemory() / base);

        try {
            rt.exec("notepad.exe");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    public static void TestClass() {
        Integer i = 100;
        System.out.println(i.getClass());
        System.out.println(Integer.class);
    }

}
