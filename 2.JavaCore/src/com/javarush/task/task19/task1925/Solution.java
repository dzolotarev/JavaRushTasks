package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) return;
        ArrayList<String> words = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready()) {
            String line = reader.readLine();
            String[] lines = line.split(" ");
            for (String s : lines) {
                String striped = s.trim();
                if (striped.length() > 6) {
                    words.add(striped);
                }
            }

        }
        reader.close();
        String result = String.join(",", words);
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        writer.write(result);
        writer.close();


    }
}
