package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(input);
        String filePath1 = buffer.readLine();
        String filePath2 = buffer.readLine();
        String filePath3 = buffer.readLine();

        try (FileInputStream fileStream1 = new FileInputStream(filePath1);
             FileOutputStream fileStream2 = new FileOutputStream(filePath2);
             FileOutputStream fileStream3 = new FileOutputStream(filePath3)) {


            int fullBuffLength = fileStream1.available();

            byte[] fullBuff = new byte[fullBuffLength];
            fileStream1.read(fullBuff);

            int half2 = fullBuffLength / 2;

            fileStream2.write(fullBuff, 0, fullBuffLength - half2);
            fileStream3.write(fullBuff, fullBuffLength - half2, half2);
        }
    }
}

