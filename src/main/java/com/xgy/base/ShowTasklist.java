package com.xgy.base;

import java.io.IOException;
import java.util.Scanner;

//JavaWindowsCommandUtil
public class ShowTasklist {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // startTask("E:\\Fetion\\Fetion.exe");
        // killTask("javaw");
        showTaskList();

    }

    /**
     * ɱ��һ������
     *
     * @param task
     */
    public static void killTask(String task) {

        try {
            Process process = Runtime.getRuntime().exec("taskList");
            Scanner in = new Scanner(process.getInputStream());
            int count = 0;
            while (in.hasNextLine()) {
                count++;
                String temp = in.nextLine();

                if (temp.contains(task)) {
                    String[] t = temp.split(" ");
                    // �жϸý�����ռ�ڴ��Ƿ����20M
                    if (Integer.parseInt(t[t.length - 2].replace(",", "")) > 20000) {
                        temp = temp.replaceAll(" ", "");
                        // ���pid
                        String pid = temp.substring(9, temp.indexOf("Console"));
                        Runtime.getRuntime().exec("tskill " + pid);

                        // dos�¿�cmd���� ntsd -c q -p PID
                        // Runtime.getRuntime().exec("ntsd -c q -p 1528");
                    }
                }
                // System.out.println(count + ":" + temp);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * ��ʾ��ǰ���������н���
     */
    public static void showTaskList() {

        try {
            Process process = Runtime.getRuntime().exec("taskList");
            Scanner in = new Scanner(process.getInputStream());
            int count = 0;
            while (in.hasNextLine()) {
                count++;
                System.out.println(count + ":" + in.nextLine());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * ����һ������
     *
     * @param task
     */
    public static void startTask(String task) {
        try {
            Runtime.getRuntime().exec(task);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
