package com.xgy.base.container;

import java.util.*;
import java.util.Map.Entry;

public class MyMap {

    public static void main(String[] args) {
        base();
//		test();

    }

    static void base() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("sa1", "dd1");
        map.put("sa2", "dd2");
        map.put("sa3", "dd3");
        map.put("sa4", "dd4");

        //获取map的基本信息
        System.out.println("size = " + map.size());//实际大小
        System.out.println("size = " + map.size());//初始大小
        System.out.println("size = " + map.size());//容量

        String key = "sa";
        if (map.get(key) != null) {
            String value = map.get(key).toString();
            System.out.println(value);
        } else {
            System.out.println("key is not exist");
        }

        //map的遍历方式
        for (Object obj : map.keySet()) {
            Object value = map.get(obj);
            System.out.println(obj + ":" + value);
        }
        for (Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }

        Set<Entry<String, String>> set = map.entrySet();
        Iterator<Entry<String, String>> i = set.iterator();
        while (i.hasNext()) {
            Entry<String, String> entry1 = (Entry<String, String>) i.next();
            System.out.println(entry1.getKey() + "==" + entry1.getValue());
        }

        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String key1;
            String value;
            key1 = it.next().toString();
            value = map.get(key1);
            System.out.println(key1 + "--" + value);
        }

        Iterator<Entry<String, String>> it2 = map.entrySet().iterator();
        System.out.println(map.entrySet().size());
        while (it.hasNext()) {
            Entry<String, String> entry = (Entry<String, String>) it2.next();
            String key1 = entry.getKey().toString();
            String value1 = entry.getValue().toString();
            System.out.println(key1 + "====" + value1);
        }

    }

    static void test() {
        // HashMap
        System.out.println("------HashMap------");
        HashMap<String, String> hsMap = new HashMap<String, String>();
        hsMap.put("3", "Value3");
        hsMap.put("1", "Value1");
        hsMap.put("2", "Value2");
        hsMap.put("b", "ValueB");
        hsMap.put("a", "ValueA");
        Iterator<Entry<String, String>> it = hsMap.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, String> e = (Entry<String, String>) it.next();
            System.out.println("Key: " + e.getKey() + "--Value: "
                    + e.getValue());
        }

        // TreeMap
        System.out.println("------TreeMap------");
        TreeMap<String, String> teMap = new TreeMap<String, String>();
        teMap.put("3", "Value3");
        teMap.put("1", "Value1");
        teMap.put("2", "Value2");
        teMap.put("b", "ValueB");
        teMap.put("a", "ValueA");
        Iterator<Entry<String, String>> tit = teMap.entrySet().iterator();
        while (tit.hasNext()) {
            Entry<String, String> e = (Entry<String, String>) tit
                    .next();
            System.out.println("Key: " + e.getKey() + "--Value: "
                    + e.getValue());
        }

        // LinkedHashMap
        System.out.println("--LinkedHashMap--");
        LinkedHashMap<String, String> lhsMap = new LinkedHashMap<String, String>();
        lhsMap.put("3", "Value3");
        lhsMap.put("1", "Value1");
        lhsMap.put("2", "Value2");
        lhsMap.put("b", "ValueB");
        lhsMap.put("a", "ValueA");
        Iterator<Entry<String, String>> lit = lhsMap.entrySet().iterator();
        while (lit.hasNext()) {
            Entry<String, String> e = (Entry<String, String>) lit
                    .next();
            System.out.println("Key: " + e.getKey() + "--Value: "
                    + e.getValue());
        }
    }

}
