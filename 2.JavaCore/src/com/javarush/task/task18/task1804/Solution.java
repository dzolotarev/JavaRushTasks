package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(input);
        String filePath = buffer.readLine();
        int[] resultArray = new int[256];
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            while (fileInputStream.available() > 0) {
                resultArray[fileInputStream.read()] += 1;
            }
        }
        int min = 256;
        for (int i = 0; i < resultArray.length; i++) {
            if (resultArray[i] < min && resultArray[i] >= 1) min = resultArray[i];
        }
        for (int i = 0; i < resultArray.length; i++) {
            if (resultArray[i] == min) System.out.print(i + " ");
        }
    }
}
