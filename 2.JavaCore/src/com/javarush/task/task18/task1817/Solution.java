package com.javarush.task.task18.task1817;

import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) return;

        int countAll = 0;
        int countWhitespaces = 0;
        char whitespace = ' ';
        try (FileReader fileReader = new FileReader(args[0])) {
            while (fileReader.ready()) {
                char readChar = (char) fileReader.read();
                countAll++;
                if (whitespace == readChar) countWhitespaces++;
            }
        }
        double result = (double) countWhitespaces/ (double) countAll *100;
        System.out.printf("%.2f",result);
    }
}
