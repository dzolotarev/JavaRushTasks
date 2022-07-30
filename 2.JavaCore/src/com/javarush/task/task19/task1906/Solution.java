package com.javarush.task.task19.task1906;

import java.io.*;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1;
        String file2;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            file1 = reader.readLine();
            file2 = reader.readLine();
        }

        try (FileReader reader = new FileReader(file1);
             FileWriter writer = new FileWriter(file2)) {
            int count = 1;
            while (reader.ready()) {
                int data = reader.read();
                if (count % 2 == 0) {
                    writer.write(data);
                }
                count++;
            }

        }

    }
}
