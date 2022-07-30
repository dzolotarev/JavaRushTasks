package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
//        words.add("А");
//        words.add("Б");
//        words.add("В");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        while (reader.ready()) {
            int count = 0;
            String line = reader.readLine();
            String[] lines = line.split(" ");
            for (int i = 0; i < words.size(); i++) {
                for (int j = 0; j < lines.length; j++) {
                    if (lines[j].equals(words.get(i))) {
                        count++;
                    }
                }
            }
            if (count == 2) {
                System.out.println(line);
            }
        }
        reader.close();

    }
}
