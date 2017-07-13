package com.xgy.redis;

/**
 * Created by Administrator on 2016/10/26.
 */
public class ExportAllRedis {

    private MyRedis redis = new MyRedis();

    public static void main(String[] args) {

        ExportAllRedis redis = new ExportAllRedis();
        redis.Start();

    }

    public boolean Start() {
        try {

            if (!redis.ConnectRedis()) {
                System.out.println("ConnectRedis failed");
                return false;
            }

            //遍历所有数据库
            for (int i = 0; i < 16; ++i) {
                redis.SelectDb(i);
                //一个数据库可以存放各种数据类型
                //获取同一种数据类型的key
            }


        } finally {
            if (!redis.CloseRedis()) {
                System.out.println("CloseRedis failed");
            }
        }


        return true;
    }
}
