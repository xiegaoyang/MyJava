package com.xgy.mongodb;

/**
 * Created by root on 16-10-20.
 */

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MyMongodb {
    public static void main(String args[]) {
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient("192.168.1.25", 27017);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
            System.out.println("Connect to database successfully");

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
