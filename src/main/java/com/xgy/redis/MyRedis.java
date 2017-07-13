package com.xgy.redis;

/**
 * Created by root on 16-10-20.
 */

import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

import java.util.*;


public class MyRedis {

    private String IP = "123.207.238.69";
    private int PORT = 6379;
    //private final String PASSWORD = "123";

    private Jedis redis = null;

    MyRedis() {

    }

    MyRedis(String ip, int port) {
        this.IP = ip;
        this.PORT = port;
    }

    public static void main(String[] args) {
        MyRedis redis = new MyRedis();
        try {

            if (!redis.ConnectRedis()) {
                System.out.println("ConnectRedis failed");
                return;
            }

//            redis.RedisString();
//            redis.RedisHash();
//            redis.RedisList();
//            redis.RedisSet();
//            redis.RedisZset();
//
//            redis.PrintAllKeys();

        } finally {
            if (!redis.CloseRedis()) {
                System.out.println("CloseRedis failed");
            }
        }
    }

    public static void TestRedis() {
        //连接本地的 Redis 服务
        Jedis redis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //查看服务是否运行
        System.out.println("Server is running: " + redis.ping());
    }

    public void SetLogger(Logger logger) {
        Logger logger1 = logger;
    }

    private void Info(String msg) {
        //Info(msg);
        System.out.println(msg);
    }

    public void SelectDb(int index) {
        redis.select(index);
    }


    //    public void PrintAllKeys() {
//
//        for (int i=0; i<16; ++i) {
//            redis.select(i);
//            Set<String> allKeys = redis.keys("*");
//            for (String key : allKeys) {
//                String value = "";
//                //获取key对应的数据类型
//                String type = redis.type(key);
//                System.out.println("key   : " + key + ", 类型：" + type);
//                System.out.print("value : ");
//
//                if(type.equals("string")){
//                    //get(key)方法返回key所关联的字符串值
//                    value = redis.get(key);
//                    System.out.print(value);
//                }else if(type.equals("hash")){
//                    //以下方法仅适用于list.size=1时，否者value将取集合中最后一个元素的值
//                    List<String> list = redis.hvals(key);//hvals(key)返回哈希表 key 中所有域的值
//                    //Set<String> set = redis.hkeys(key);
//                    Iterator<String> it = list.iterator();
//                    while(it.hasNext()){
//                        value = it.next();
//                        System.out.print(value + " ");
//                    }
//                }else if(type.equals("list")){
//
//                    List<String> list = redis.lrange(key, 0, 10);
//                    for (i = 0; i < list.size(); i++) {
//                        System.out.print(list.get(i) + " ");
//                    }
//
//                }else if(type.equals("set")){
//
//
//                    System.out.print(redis.smembers(key));
//
//                }else if(type.equals("zset")) {
//
//                    System.out.print(redis.zrange(key, 0, -1));
//                }
//                System.out.println("\n");
//            }
//        }
//    }

    public int GetDbCounts() {
        //return redis.getDB();
        return 0;
    }

    public void PrintAllKeys() {

        for (int i = 0; i < 16; ++i) {
            Info("第" + i + "个数据库 :  start");
            redis.select(i);
            Set<String> allKeys = redis.keys("*");
            for (String key : allKeys) {
                String value = "";
                //获取key对应的数据类型
                String type = redis.type(key);
                Info("key   : " + key + ", 类型：" + type);


                if (type.equals("string")) {
                    //get(key)方法返回key所关联的字符串值
                    Info("value : " + redis.get(key));

                } else if (type.equals("hash")) {
                    //以下方法仅适用于list.size=1时，否者value将取集合中最后一个元素的值
                    List<String> list = redis.hvals(key);//hvals(key)返回哈希表 key 中所有域的值
                    Info("value : " + list.toString());
                } else if (type.equals("list")) {

                    List<String> list = redis.lrange(key, 0, 10);
                    Info("value : " + list.toString());

                } else if (type.equals("set")) {


                    Info(redis.smembers(key).toString());

                } else if (type.equals("zset")) {

                    Info(redis.zrange(key, 0, -1).toString());
                }

            }
            Info("第" + i + "个数据库 :  end\n");
        }
    }

    public boolean ConnectRedis() {
        if (null == redis) {
            redis = new Jedis(IP, PORT);
            if (null == redis) {
                return false;
            }
        }
        //查看服务是否运行
        Info("Server is running: " + redis.ping());
        //redis.auth("redis");//验证密码
        return true;
    }

    public boolean CloseRedis() {
        return true;
    }

    public boolean Insert(String key, String name) {
        redis.set(key, name);
        return true;
    }

    public boolean Delete(String key) {
        //KEYS
        Set keys = redis.keys("*");    //列出所有的key，查找特定的key如：redis.keys("foo")
        Iterator it = keys.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            //Info(obj);

        }
        return true;
    }

    public boolean Modify(String key, String name) {

        return true;
    }

    public boolean Query(String key) {

        return true;
    }

    public void RedisBase() {
        // 获取数据并输出
        List<String> list = (List<String>) redis.keys("*");
        for (int i = 0; i < list.size(); i++) {
            Info("List of stored keys:: " + list.get(i));
        }
    }

    public void RedisString() {
        Info("RedisString start");

        //设置 redis 字符串数据
        redis.set("name", "xiegy");
        redis.set("sex", "男");
        redis.set("age", "27");
        redis.set("work", "工程师");

        // 获取存储的数据并输出
        Info("Stored string in redis, name = " + redis.get("name") +
                ", sex = " + redis.get("sex") +
                ", age = " + redis.get("age") +
                ", work = " + redis.get("work")
        );
        Info("RedisString end\n");
    }

    public void RedisSet() {
        Info("RedisSet start");
        // 添加数据
        redis.sadd("sets", "HashSet");
        redis.sadd("sets", "SortedSet");
        redis.sadd("sets", "TreeSet");
        // 判断value是否在列表中
        Info(redis.sismember("sets", "TreeSet").toString());
        Info("RedisSet end\n");
    }

    public void RedisZset() {
        Info("RedisZset start");
        // 添加数据
        redis.zadd("zset", 10.1, "hello");
        redis.zadd("zset", 10.0, ":");
        redis.zadd("zset", 9.0, "zset");
        redis.zadd("zset", 11.0, "zset!");
        // 元素个数
        Info(redis.zcard("zset").toString());
        // 元素下标
        Info(redis.zscore("zset", "zset").toString());
        // 集合子集
        Info(redis.zrange("zset", 0, -1).toString());
        Info("RedisZset end\n");
    }

    public void RedisList() {
        Info("RedisList start");

        //存储数据到列表中
        redis.lpush("tutorial-list", "Redis");
        redis.lpush("tutorial-list", "Mongodb");
        redis.lpush("tutorial-list", "Mysql");

        // 获取存储的数据并输出
        List<String> list = redis.lrange("tutorial-list", 0, 5);
        for (int i = 0; i < list.size(); i++) {
            Info("Stored string in redis:: " + list.get(i));
        }


        //开始前，先移除所有的内容
        redis.del("java framework");
        Info(redis.lrange("java framework", 0, -1).toString());

        //先向key java framework中存放三条数据
        redis.lpush("java framework", "spring");
        redis.lpush("java framework", "struts");
        redis.lpush("java framework", "hibernate");
        //再取出所有数据jedis.lrange是按范围取出，
        // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
        Info(redis.lrange("java framework", 0, -1).toString());

        redis.del("java framework");
        redis.rpush("java framework", "spring");
        redis.rpush("java framework", "struts");
        redis.rpush("java framework", "hibernate");
        Info(redis.lrange("java framework", 0, -1).toString());
        Info("RedisList end\n");

    }

    public void RedisHash() {
        Info("RedisHash start");

        Map<String, String> map = new HashMap<String, String>();

        map.put("name", "xiegy");
        map.put("age", "29");
        map.put("sex", "男");
        map.put("work", "it");
        map.put("addr", "深圳龙华");

        redis.hmset("user", map); //会多次设置
        //之后在命令行操作
        //hgetall user：获取所有信息
        //hget user name : 获取name

        List<String> rrsmap = redis.hmget("user", "name", "age", "sex");
        Info(rrsmap.toString());//[xiegy, 29, 男]

        //删除map中的某个键值
        redis.hdel("user", "age");
        Info(redis.hmget("user", "age").toString()); //因为删除了，所以返回的是null
        Info(redis.hlen("user").toString()); //返回key为user的键中存放的值的个数2
        Info(redis.exists("user").toString());//是否存在key为user的记录 返回true
        Info(redis.hkeys("user").toString());//返回map对象中的所有key
        Info(redis.hvals("user").toString());//返回map对象中的所有value

        Iterator<String> iter = redis.hkeys("user").iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            Info(key + ":" + redis.hmget("user", key));
        }

        Info("RedisHash end\n");

    }
}

