package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена знаков
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

            Pattern pattern = Pattern.compile("\\.");
            Matcher matcher = pattern.matcher(word);
            String resolve = matcher.replaceAll("!");
            writer.write(resolve);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
