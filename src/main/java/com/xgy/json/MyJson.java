package com.xgy.json;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by root on 16-10-20.
 */
public class MyJson {

    //json�ַ���ת��Ϊjson����
    public static void jsonStrToJsonObj() {

//        String str = "{\"name\":\"xgy\"}";
//        JSONObject object = JSONObject.parseObject(str);
//        System.out.println(object.getString("name"));

        String str = "[{\n" +
                "\t\"address\": \"������������\",\n" +
                "\t\"phone\": \"15919492257\",\n" +
                "\t\"work\": \"�������ʦ\",\n" +
                "\t\"sex\": \"��\",\n" +
                "\t\"name\": \"л����\",\n" +
                "\t\"age\": 25\n" +
                "},\n" +
                "{\n" +
                "\t\"address\": \"������������\",\n" +
                "\t\"phone\": \"15919492257\",\n" +
                "\t\"work\": \"�������ʦ\",\n" +
                "\t\"sex\": \"��\",\n" +
                "\t\"name\": \"л����\",\n" +
                "\t\"age\": 26\n" +
                "},\n" +
                "{\n" +
                "\t\"address\": \"������������\",\n" +
                "\t\"phone\": \"15919492257\",\n" +
                "\t\"work\": \"�������ʦ\",\n" +
                "\t\"sex\": \"��\",\n" +
                "\t\"name\": \"л����\",\n" +
                "\t\"age\": 27\n" +
                "},\n" +
                "{\n" +
                "\t\"address\": \"������������\",\n" +
                "\t\"phone\": \"15919492257\",\n" +
                "\t\"work\": \"�������ʦ\",\n" +
                "\t\"sex\": \"��\",\n" +
                "\t\"name\": \"л����\",\n" +
                "\t\"age\": 28\n" +
                "}]";
//        JSONObject object = JSONObject.parseObject(str); //�����飬������ôת��
//        JSONArray array = JSON.parseArray(str);
        JSONArray array = JSONArray.parseArray(str);
        System.out.println(array.size());
        List<Person> personList = JSON.parseArray(str, Person.class);
        for (Person item : personList) {
            System.out.println(item.toString());
        }
    }

    //json����ת��Ϊ�ַ���
    public static void jsonObjToStr() {
        String str = "{\"name\":\"xgy\"}";
        JSONObject object = JSONObject.parseObject(str);
        System.out.println(object.toString());
        System.out.println(object.toJSONString());
    }

    //Java����ת��Ϊjson����
    public static void javaObjToJsonObj() {
        Person person = new Person("л����", "��", 28, "�������ʦ", "������������", "15919492257");
        JSONObject obj = (JSONObject) JSONObject.toJSON(person);
        System.out.println(obj.getString("name"));
        System.out.println(obj.getIntValue("age"));
        System.out.println(obj.getString("phone"));
        System.out.println(obj.toJSONString());
    }

    //json����ת��ΪJava����
    public static void jsonObjToJavaObj() {
        //�������
//        String str = "{\"address\":\"������������\",\"phone\":\"15919492257\",\"work\":\"�������ʦ\",\"sex\":\"��\",\"name\":\"л����\",\"age\":28}";
//        Person person = new Person();
//        person = JSONObject.parseObject(str, person.getClass());
//        System.out.println(person.toString());

        //��һ���ֶΣ����ֶ�ֵĬ��Ϊ��
//        String str = "{\"phone\":\"15919492257\",\"work\":\"�������ʦ\",\"sex\":\"��\",\"name\":\"л����\",\"age\":28}";
//        Person person = new Person();
//        System.out.println(person.toString());
//        person = JSONObject.parseObject(str, person.getClass());
//        System.out.println(person.toString());

        //��һ���ֶΣ�û��Ӱ��
        String str = "{\"test\":\"test\", \"address\":\"������������\",\"phone\":\"15919492257\",\"work\":\"�������ʦ\",\"sex\":\"��\",\"name\":\"л����\",\"age\":28}";
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
