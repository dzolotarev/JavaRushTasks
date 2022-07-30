package com.javarush.task.task18.task1809;

import java.io.*;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String filePath1;
        String filePath2;
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
            filePath1 = buffer.readLine();
            filePath2 = buffer.readLine();
        }

        try (FileInputStream fileStream1 = new FileInputStream(filePath1);
             FileOutputStream fileStream2 = new FileOutputStream(filePath2)) {

            int fileLenght = fileStream1.available();
            byte[] buff = new byte[fileLenght];
            byte[] reverseBuff = new byte[fileLenght];
            fileStream1.read(buff);
            for (int i = 0; i < fileLenght ; i++) {
                reverseBuff[fileLenght-1-i]=buff[i];
            }
            fileStream2.write(reverseBuff);
        }
    }
}
