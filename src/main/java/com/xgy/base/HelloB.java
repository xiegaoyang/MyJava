package com.xgy.base;

/**
 * Created by hadoop on 2017/4/17.
 */

/*
解析：说实话我觉得这题很好，考查静态语句块、构造语句块（就是只有大括号的那块）以及构造函数的执行顺序。

对象的初始化顺序：
（1）类加载之后，按从上到下（从父类到子类）执行被static修饰的语句；
（2）当static语句执行完之后,再执行main方法；
（3）如果有语句new了自身的对象，将从上到下执行构造代码块、构造器（两者可以说绑定在一起）。

 */
class HelloA {

    private static int a = 1;

    static {
        a += 2;
        System.out.println("static A");
    }


    {
        System.out.println("I'm A class");
    }

    public HelloA() {
        System.out.println("HelloA");
    }

}

public class HelloB extends HelloA {
    static {
        System.out.println("static B");
    }

    {
        System.out.println("I'm B class");
    }

    public HelloB() {
        System.out.println("HelloB");
    }

    public static void main(String[] args) {

        System.out.println("-------main start-------");
        new HelloB();
        new HelloB();
        System.out.println("-------main end-------");
    }
}
