package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // if (args.length == 0) return;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();

        ArrayList<String> fileStrings = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(path))) {

            while (fileReader.ready()) {
                fileStrings.add(fileReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String string : fileStrings) {
            String[] strings = string.split(" ");
            if (strings[0].equals(args[0])) {
                System.out.println(string);
            }
        }


    }
}
/*
public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str;
        try (BufferedReader bufferedFileReader = new BufferedReader(new FileReader(reader.readLine()))) {
            while ((str = bufferedFileReader.readLine()) != null) {
                if (str.startsWith(args[0] + " ")) {
                    System.out.println(str);
                    break;
                }
            }
        }
    }
 */