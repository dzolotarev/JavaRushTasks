package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Составить цепочку слов
*/

public class Solution {


    public static void main(String[] args) {

        StringBuilder str = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())))) {
            while (fileReader.ready()) {
                if (str.length() == 0) {
                    str.append(fileReader.readLine());
                } else {
                    str.append(" ").append(fileReader.readLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        StringTokenizer tokenizer = new StringTokenizer(str.toString(), " ");
//        while (tokenizer.hasMoreElements()) {
//            wordList.add(tokenizer.nextToken());
//        }




        StringBuilder result = getLine(str.toString());
        System.out.println(result.toString());

    }

    public static StringBuilder getLine(String... words) {
        List<String> wordList = new ArrayList<>();

        for (String s: words) {
            wordList.add(s);
        }


        return null;
    }
}
