package com.xgy.postgresql;


/**
 * Created by root on 16-10-20.
 */

class Person extends Object {
    public String name;
    public String sex;
    public int age;
    public String work;

    public String addr;
    public String mobile;

    Person(String name, String sex, int age, String work, String addr, String mobile) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.work = work;
        this.addr = addr;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}

