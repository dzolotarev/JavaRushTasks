package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String inputFile = args[0];
        String outputFile = args[1];

        Charset utf8 = StandardCharsets.UTF_8;
        Charset windows1251 = Charset.forName("Windows-1251");

        FileInputStream fileInputStream = new FileInputStream(inputFile);
        Reader reader = new InputStreamReader(fileInputStream, windows1251);

        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        Writer writer = new OutputStreamWriter(fileOutputStream, utf8);

        int c;

        while ((c = reader.read()) != -1) {
            writer.write(c);
        }

        reader.close();
        writer.close();
    }


}
