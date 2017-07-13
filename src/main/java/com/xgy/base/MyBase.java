package com.xgy.base;

import static java.lang.Thread.sleep;

/**
 * Created by root on 16-10-20.
 */
public class MyBase {


    public static void test() {

    }


    public static void main(String[] args) {


        while (true) {
            System.out.println("Hello World!");

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
