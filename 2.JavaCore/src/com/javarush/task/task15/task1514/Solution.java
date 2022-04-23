package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(34.44d,"Test0");
        labels.put(34.45d,"Test1");
        labels.put(34.46d,"Test2");
        labels.put(34.47d,"Test3");
        labels.put(34.48d,"Test4");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
