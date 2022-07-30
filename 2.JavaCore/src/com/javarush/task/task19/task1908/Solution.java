package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.regex.Pattern;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) {
        String file1 = "";
        String file2 = "";
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            file1 = reader.readLine();
            file2 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file1)); BufferedWriter writer = new BufferedWriter(new FileWriter(file2))) {
            StringBuilder word = new StringBuilder();
            String line="";

            while ((line = reader.readLine()) != null) {
                word.append(line);
            }

            String[] stringArray = word.toString().split("\\s");
            for (int i = 0; i < stringArray.length; i++) {
                if (Pattern.matches("\\d+$", stringArray[i]) && i < (stringArray.length - 1)) {
                    writer.write(stringArray[i] + " ");
                } else if (Pattern.matches("\\d+$", stringArray[i])) {
                    writer.write(stringArray[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
