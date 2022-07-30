package com.javarush.task.task18.task1824;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = "";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            while (true){
                fileName = reader.readLine();
                try(FileInputStream inputStream = new FileInputStream(fileName)){
                }
            }
        } catch (IOException e) {
            System.out.println(fileName);;
        }

    }
}