package com.xgy.log;

import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2016/10/22.
 */
public class MyLog4j {

    private Logger logger = Logger.getLogger("MainLogger");

    public static void main(String[] args) {
        MyLog4j myLog4j = new MyLog4j();
        myLog4j.test();
    }

    public void test() {
        logger.info("wo jiao xgy");
    }

}
