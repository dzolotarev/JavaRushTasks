package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        if (args.length < 3) {
            throw new IllegalArgumentException();
        }
        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw")) {
            int bufferSize = text.getBytes().length;
            byte[] buffer = new byte[bufferSize];
            randomAccessFile.seek(number);
            randomAccessFile.read(buffer, 0, bufferSize);
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.write(text.equals(new String(buffer)) ? "true".getBytes() : "false".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
