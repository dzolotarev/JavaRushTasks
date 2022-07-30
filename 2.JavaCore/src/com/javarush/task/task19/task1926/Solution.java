package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = null;

        try(BufferedReader r = new BufferedReader(new InputStreamReader(System.in))){
            fileName = r.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            while (reader.ready()){
                String line = reader.readLine();
                StringBuilder sb = new StringBuilder(line);
                System.out.println(sb.reverse());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
