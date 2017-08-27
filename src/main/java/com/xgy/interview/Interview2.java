package com.xgy.interview;

/**
 * Created by hadoop on 2017/8/27.
 */

interface A {
    int a = 0;
}

class B {
    int a = 1;

    public void output() {
        System.out.println(a);
    }
}

class C extends B implements A {

}

public class Interview2 {
    public static void main(String[] args) {
        C c = new C();
        c.output();
    }
}
