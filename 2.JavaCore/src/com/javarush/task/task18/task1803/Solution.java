package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
/* 
Самые частые байты
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
        int max = -1;
        for (int i = 0; i < resultArray.length; i++) {
            if (resultArray[i] > max) max = resultArray[i];
        }
        for (int i = 0; i < resultArray.length; i++) {
            if (resultArray[i] == max) System.out.print(i + " ");
        }
    }
}
