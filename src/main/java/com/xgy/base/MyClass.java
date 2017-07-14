package com.xgy.base;

/**
 * Created by root on 16-10-20.
 */
public class MyClass {

    public static int count = 1;
    private double radius = 0;

    public MyClass(double radius) {
        this.radius = radius;
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass(10);
        MyClass.Draw draw = myClass.new Draw();
        draw.drawSahpe();
    }

    //内部类
    class Draw {
        public void drawSahpe() {
            System.out.println(radius);  //外部类的private成员
            System.out.println(count);   //外部类的静态成员
        }
    }

}
