package com.xgy.redis;


/**
 * Created by Administrator on 2016/10/26.
 */
public class ExportUserInfoRedisToFile {

    private final String IP = "172.16.15.144";
    private final int[] PORTS = {6378, 6379};

    MyRedis redis = null;

    //public static Logger logger = Logger.getLogger("MainLogger");

    public static void main(String[] args) {
        ExportUserInfoRedisToFile redis = new ExportUserInfoRedisToFile();
        redis.Start();
    }

    public boolean Start() {

        //System.out.println("***************************************************************************************************");
        System.out.println("***************************************************************************************************");
        for (int i = 0; i < PORTS.length; ++i) {
            try {
                redis = new MyRedis(IP, PORTS[i]);
                //redis.SetLogger(logger);

                if (!redis.ConnectRedis()) {
                    System.out.println("ConnectRedis failed");
                    return false;
                }

                System.out.println("collect redis:" + PORTS[i] + " info : start");


                redis.PrintAllKeys();


                System.out.println("collect redis:" + PORTS[i] + " info : end\n");


            } finally {
                if (!redis.CloseRedis()) {
                    System.out.println("CloseRedis failed");
                }
            }
        }
        System.out.println("***************************************************************************************************\n\n");
        return true;
    }
}
