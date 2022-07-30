package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length == 0) return;
        String filePath = args[0];

        TreeMap<String, Double> map = new TreeMap<String, Double>();

        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        while (reader.ready()) {
            String line = reader.readLine();
            String[] arr = line.split(" ");
            if (map.containsKey(arr[0])) {
                map.put(arr[0], map.get(arr[0]) + Double.parseDouble(arr[1]));
            } else {

                map.put(arr[0], Double.parseDouble(arr[1]));
            }

        }
        reader.close();

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(key + " " + value);
        }

    }
}

// Авторское решение
// public class Solution {
//    public static void main(String[] args) {
//        TreeMap<String, Double> salary = new TreeMap<>();
//
//        String fileName = args[0];
//
//        try (BufferedReader rd = new BufferedReader(new FileReader(fileName))) {
//            String[] splitedLine;
//            String line;
//            Double currentValue;
//
//            while ((line = rd.readLine()) != null) {
//                splitedLine = line.split(" ");
//                String name = splitedLine[0];
//                double value = Double.parseDouble(splitedLine[1]);
//
//                if (salary.containsKey(name)) {
//                    currentValue = salary.get(name);
//                    salary.put(name, value + currentValue);
//                } else {
//                    salary.put(name, value);
//                }
//            }
//        } catch (IOException ignore) {
//            /*NOP */
//        }
//
//        for (String key : salary.keySet()) {
//            System.out.println(key + " " + salary.get(key));
//        }
//    }
//}
