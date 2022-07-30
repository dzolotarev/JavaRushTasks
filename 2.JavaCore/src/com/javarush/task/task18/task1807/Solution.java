package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(input);
        String filePath = buffer.readLine();
        int counter = 0;

        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            while (fileInputStream.available() > 0) {
                int symbol = fileInputStream.read();
                if (symbol == 44) {
                    counter += 1;
                }
            }
        }
        System.out.println(counter);
    }
}
