package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
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
            long fileLength = randomAccessFile.length();
            randomAccessFile.seek(Math.min(fileLength, number));
            randomAccessFile.write(text.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
