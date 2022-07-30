package com.javarush.task.task18.task1821;

import java.io.FileReader;
import java.io.IOException;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length == 0) return;

        int[] resultArray = new int[256];
        try (FileReader reader = new FileReader(args[0]);) {
            while (reader.ready()) {
                resultArray[reader.read()] += 1;
            }
        }
        for (int i = 0; i < resultArray.length; i++) {
            if (resultArray[i] != 0) {
                System.out.println((char) i + " " + resultArray[i]);
            }

        }

    }
}
