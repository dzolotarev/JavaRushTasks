package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(input);
        String filePath = buffer.readLine();
        int minByte = 255;

        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {

            while (fileInputStream.available() > 0) {
                int tmp = fileInputStream.read();
                if (tmp < minByte) {
                    minByte = tmp;
                }
            }
        }
        System.out.println(minByte);
    }
}
