package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        printFiveSortedLetters(readFromFileAndLowerCase(args[0]));
    }

    private static String readFromFileAndLowerCase(String filename) throws IOException {
        if (filename == null) {
            throw new IllegalArgumentException("File name can't be null");
        }
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(filename);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                stringBuilder.append(reader.readLine());
            }
        }
        return stringBuilder.toString().toLowerCase();
    }

    private static void printFiveSortedLetters(String string){
        if (string == null) {
            throw new IllegalArgumentException("String length can't be null");
        }

        TreeSet<String> charSet = new TreeSet<>();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if ((ch >= 'a' && ch <= 'z')){
                charSet.add(String.valueOf(ch));
            }
        }
        charSet.stream().limit(5).forEach(System.out::print);
        System.out.println();
    }
}