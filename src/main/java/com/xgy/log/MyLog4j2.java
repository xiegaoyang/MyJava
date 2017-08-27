package com.xgy.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

/**
 * Created by hadoop on 2017/8/27.
 */

//日志级别从低到高分为TRACE < DEBUG < INFO < WARN < ERROR < FATAL，
//如果设置为WARN，则低于WARN的信息都不会输出。对于Loggers中level的定义同样适用。

public class MyLog4j2 {

    private Logger logger = (Logger) LogManager.getLogger(MyLog4j2.class.getName());

    public static void main(String[] args) {
//        Logger logger = (Logger) LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
//        logger.trace("trace level");
//        logger.debug("debug level");
//        logger.info("info level");
//        logger.warn("warn level");
//        logger.error("error level");
//        logger.fatal("fatal level");

        MyLog4j2 myLog4j2 = new MyLog4j2();
        myLog4j2.test();

    }

    public void test() {
        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level");
        logger.fatal("fatal level");
    }

}
