package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String fileName = input.readLine();
        input.close();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        while (reader.ready()) {
            String line = reader.readLine();
            String[] lines = line.split(" ");
            ArrayList<String> linesList = new ArrayList<>(Arrays.asList(lines));
            for (int i = 0; i < linesList.size(); i++) {
                if (linesList.get(i).matches("[0-9]+")) {
                    int index = Integer.parseInt(linesList.get(i));
                    if (index <= 12) {
                        linesList.set(i, map.get(index));
                    }
                }else if (linesList.get(i).matches("[0-9]+\\W")){
                    int index = Integer.parseInt(linesList.get(i).substring(0,linesList.get(i).length()-1));
                    String lastSymbol = linesList.get(i).substring(linesList.get(i).length()-1,linesList.get(i).length());
                    if (index <= 12) {
                        linesList.set(i, map.get(index)+lastSymbol);
                    }
                }
            }
            String newLine = String.join(" ", linesList);
            System.out.println(newLine);
        }
        reader.close();

    }
}
