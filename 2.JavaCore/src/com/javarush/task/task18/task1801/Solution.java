package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(input);
        String filePath = buffer.readLine();
        FileInputStream fileInputStream = new FileInputStream(filePath);
        int maxByte = 0;
        while (fileInputStream.available() > 0) {
            int tmp = fileInputStream.read();
            if (tmp> maxByte){
                maxByte = tmp;
            }
        }
        fileInputStream.close();
        System.out.println(maxByte);

    }
}
