package com.xgy.base;

import static org.junit.Assert.*;

/**
 * Created by gowild.cn on 2017/5/31.
 */
public class MyTestTest {
    @org.junit.Before
    public void setUp() throws Exception {
        System.out.println("setUp");
    }

    @org.junit.After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }

    @org.junit.Test
    public void test1() throws Exception {
        System.out.println("test1");
    }

    @org.junit.Test
    public void test2() throws Exception {
        System.out.println("test2");
    }

}