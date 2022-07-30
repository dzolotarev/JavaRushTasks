package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath;

        while (!(filePath = reader.readLine()).equals("exit")) {
            ReadThread readThread = new ReadThread(filePath);
            readThread.start();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;

            //implement constructor body
        }

        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            int[] resultArray = new int[256];
            try {
                FileInputStream input = new FileInputStream(fileName);
                while (input.available() > 0) {
                    resultArray[input.read()] += 1;
                }
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            int maxTimes = -1;
            int maxTimesByte = -1;
            for (int i = 0; i < resultArray.length; i++) {
                if (resultArray[i] > maxTimes) {
                    maxTimes = resultArray[i];
                    maxTimesByte = i;
                }
            }

            resultMap.put(fileName, maxTimesByte);

        }
    }
}
