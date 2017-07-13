package com.xgy.base.container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class MyContainer {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //TestList();
        TestMap();


    }

    public static void TestList() {
        ArrayList<String> strList = new ArrayList<String>();

        strList.add("xgy");
        strList.add("lt");
        strList.add("yt");

        //��һ�ֱ���
//		Iterator<String> it = strList.iterator(); //��ӵ�����������
//		it.next();
//		it.remove();
//		while(it.hasNext()){
//			String str = (String) it.next();
//			System.out.println(str);
//		}
        //�ڶ��ֱ���
        for (String str : strList) {
            System.out.println(str);
        }

        //�����ֱ���
        for (int i = 0; i < strList.size(); ++i) {
            System.out.println(strList.get(i));
        }
    }

    public static void TestSet() {

    }

    public static void TestArray() {

    }

    public static void TestMap() {
        Map<Integer, String> map = new HashMap<Integer, String>();


        map.put(9, "xgy");
        map.put(5, "yt");
        map.put(3, "lwt");//�����������ΰ�����˳���������

        //��һ�ֱ���
        Iterator<Entry<Integer, String>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Entry<Integer, String> entry = iter.next();
            Integer key = (Integer) entry.getKey();
            String value = (String) entry.getValue();

//			 Map.Entry entry = (Map.Entry) it.next(); 
//	         Object key = entry.getKey(); 
//	         Object val = entry.getValue(); 

            System.out.println(key + ":" + value);
        }

        //�ڶ��ֱ���
        for (Integer key : map.keySet()) {
            //System.out.println(map.get(key));
            System.out.println(key);
        }

    }

}
