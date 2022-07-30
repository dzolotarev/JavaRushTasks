package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) return;

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        while (reader.ready()) {
            String line = reader.readLine();
            String[] lines = line.split(" ");
            for (String s : lines) {
                char[] c = s.toCharArray();
                for (char ch : c) {
                    if (Character.isDigit(ch)) {
                        writer.write(s);
                        writer.write(" ");
                        break;
                    }
                }
            }
        }
        reader.close();
        writer.close();


    }
}
