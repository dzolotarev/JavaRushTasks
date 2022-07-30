package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String file = "";
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            file = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileReader reader = new FileReader(file);) {
            StringBuilder word = new StringBuilder();

            while (reader.ready()) {
                int data = reader.read();
                String alfa = String.valueOf((char)data);
                if (!(Pattern.matches("\\W|\\t$|\\n$|\\f$", alfa))) {
                    word.append((char) data);
                } else if (word.toString().equals("world")) {
                    count++;
                    word = new StringBuilder();
                } else {
                    word = new StringBuilder();
                }
            }
        }
        System.out.println(count);
    }
}
