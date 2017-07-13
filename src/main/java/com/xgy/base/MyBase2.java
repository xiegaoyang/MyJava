package com.xgy.base;

class Base2 {
    public String name = "xiegy";

    Base2() {

    }
}

class Drive extends Base2 {
    public String addr = "shenzhen";

    Drive() {

    }
}

public class MyBase2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Hello World��");

        Drive d = new Drive();
        System.out.println("name = " + d.name + ", addr = " + d.addr);

        Base2 b = (Base2) d;
        System.out.println("name = " + b.name + ", addr = " + ((Drive) b).addr);

        //ʱ�������
        Base2 base = GetBase();
        System.out.println(base.name);
    }

    public static Base2 GetBase() {
        Base2 base = new Base2();
        base.name = "xxx";
        return base;

    }

}
