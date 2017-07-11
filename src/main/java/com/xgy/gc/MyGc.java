package com.xgy.gc;

import com.xgy.base.container.MyArray;

import static java.lang.Thread.sleep;

/**
 * Created by hadoop on 2017/4/7.
 */
public class MyGc {

    static class Test {
        private int a = 100;
        public void output() {
            System.out.println("a = " + a);
        }
    }

    public static void main(String[] args) {
        while(true) {
            Test test = new Test();
            test.output();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
