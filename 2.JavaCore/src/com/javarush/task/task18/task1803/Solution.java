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
        List<Integer> arrayBytes = new ArrayList<>();


        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            while (fileInputStream.available() > 0) {
                int b = fileInputStream.read();
                arrayBytes.add(b);
            }
        }

        int[] resultArray = new int[256];

        for (Integer integer : arrayBytes) {
            resultArray[integer] = resultArray[integer] + 1;
        }
        int max = -1;
        for (int i = 0; i < resultArray.length; i++) {
            if (resultArray[i] > max) {
                max = resultArray[i];
            }
        }
        for (int i = 0; i < resultArray.length; i++) {
            if (resultArray[i] == max) {
                System.out.print(i + " ");
            }
        }

    }
}
