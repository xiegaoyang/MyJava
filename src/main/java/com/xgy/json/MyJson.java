package com.xgy.json;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by root on 16-10-20.
 */
public class MyJson {

    //json字符串转换为json对象
    public static void jsonStrToJsonObj() {

//        String str = "{\"name\":\"xgy\"}";
//        JSONObject object = JSONObject.parseObject(str);
//        System.out.println(object.getString("name"));

        String str = "[{\n" +
                "\t\"address\": \"深圳市龙岗区\",\n" +
                "\t\"phone\": \"15919492257\",\n" +
                "\t\"work\": \"软件工程师\",\n" +
                "\t\"sex\": \"男\",\n" +
                "\t\"name\": \"谢高扬\",\n" +
                "\t\"age\": 25\n" +
                "},\n" +
                "{\n" +
                "\t\"address\": \"深圳市龙岗区\",\n" +
                "\t\"phone\": \"15919492257\",\n" +
                "\t\"work\": \"软件工程师\",\n" +
                "\t\"sex\": \"男\",\n" +
                "\t\"name\": \"谢高扬\",\n" +
                "\t\"age\": 26\n" +
                "},\n" +
                "{\n" +
                "\t\"address\": \"深圳市龙岗区\",\n" +
                "\t\"phone\": \"15919492257\",\n" +
                "\t\"work\": \"软件工程师\",\n" +
                "\t\"sex\": \"男\",\n" +
                "\t\"name\": \"谢高扬\",\n" +
                "\t\"age\": 27\n" +
                "},\n" +
                "{\n" +
                "\t\"address\": \"深圳市龙岗区\",\n" +
                "\t\"phone\": \"15919492257\",\n" +
                "\t\"work\": \"软件工程师\",\n" +
                "\t\"sex\": \"男\",\n" +
                "\t\"name\": \"谢高扬\",\n" +
                "\t\"age\": 28\n" +
                "}]";
//        JSONObject object = JSONObject.parseObject(str); //是数组，不能这么转换
//        JSONArray array = JSON.parseArray(str);
        JSONArray array = JSONArray.parseArray(str);
        System.out.println(array.size());
        List<Person> personList = JSON.parseArray(str, Person.class);
        for (Person item : personList) {
            System.out.println(item.toString());
        }
    }

    //json对象转换为字符串
    public static void jsonObjToStr() {
        String str = "{\"name\":\"xgy\"}";
        JSONObject object = JSONObject.parseObject(str);
        System.out.println(object.toString());
        System.out.println(object.toJSONString());
    }

    //Java对象转换为json对象
    public static void javaObjToJsonObj() {
        Person person = new Person("谢高扬", "男", 28, "软件工程师", "深圳市龙岗区", "15919492257");
        JSONObject obj = (JSONObject) JSONObject.toJSON(person);
        System.out.println(obj.getString("name"));
        System.out.println(obj.getIntValue("age"));
        System.out.println(obj.getString("phone"));
        System.out.println(obj.toJSONString());
    }

    //json对象转换为Java对象
    public static void jsonObjToJavaObj() {
        //正常情况
//        String str = "{\"address\":\"深圳市龙岗区\",\"phone\":\"15919492257\",\"work\":\"软件工程师\",\"sex\":\"男\",\"name\":\"谢高扬\",\"age\":28}";
//        Person person = new Person();
//        person = JSONObject.parseObject(str, person.getClass());
//        System.out.println(person.toString());

        //少一个字段，该字段值默认为空
//        String str = "{\"phone\":\"15919492257\",\"work\":\"软件工程师\",\"sex\":\"男\",\"name\":\"谢高扬\",\"age\":28}";
//        Person person = new Person();
//        System.out.println(person.toString());
//        person = JSONObject.parseObject(str, person.getClass());
//        System.out.println(person.toString());

        //多一个字段，没有影响
        String str = "{\"test\":\"test\", \"address\":\"深圳市龙岗区\",\"phone\":\"15919492257\",\"work\":\"软件工程师\",\"sex\":\"男\",\"name\":\"谢高扬\",\"age\":28}";
//        Person person = new Person();
//        person = JSONObject.parseObject(str, person.getClass());
        Person person = JSON.parseObject(str, Person.class);
        System.out.println(person.toString());
    }

    public static void main(String[] args) {
//        jsonStrToJsonObj();
//        jsonObjToStr();
//        javaObjToJsonObj();
        jsonObjToJavaObj();
    }

}
