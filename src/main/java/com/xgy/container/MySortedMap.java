package com.xgy.container;

import java.util.*;

/**
 * Created by hadoop on 2017/7/19.
 */
public class MySortedMap {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("1", "11");
        map.put("2", "77");
        map.put("3", "33");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("排序之前:" + entry.getKey() + " 值" + entry.getValue());

        }
        System.out.println("======================================================");
        SortedMap<String, String> sort = new TreeMap<>(map);
        Set<Map.Entry<String, String>> entry1 = sort.entrySet();
        Iterator<Map.Entry<String, String>> it = entry1.iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("排序之后:" + entry.getKey() + " 值" + entry.getValue());
        }
    }
}

