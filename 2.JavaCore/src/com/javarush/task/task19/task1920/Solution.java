package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* 
Самый богатый
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) return;
        TreeMap<String, Double> map = new TreeMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        while (reader.ready()) {
            String s = reader.readLine();
            String[] arr = s.split(" ");
            String key = arr[0];
            Double value = Double.parseDouble(arr[1].trim());
            if (map.containsKey(key)) {
                Double oldValue = map.get(key);
                map.put(key, oldValue + value);
            } else {
                map.put(key, value);
            }
        }
        reader.close();


        TreeSet<Double> values = new TreeSet<>(map.values());


        Double maxValue = values.last();

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            if (value.equals(maxValue)) {
                System.out.println(key);
            }
        }


    }
}
