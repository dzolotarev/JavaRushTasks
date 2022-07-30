package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) {
        String filePath1 = "";
        String filePath2 = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            filePath1 = reader.readLine();
            filePath2 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] buffer1=null;

        try(FileInputStream fileInputStream1 = new FileInputStream(filePath1)){
            buffer1 = new byte[fileInputStream1.available()];
            int real = fileInputStream1.read(buffer1);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath1);
             FileInputStream fileInputStream2 = new FileInputStream(filePath2);
             ) {


            byte[] buffer = new byte[64];
            while (fileInputStream2.available() > 0) {
                int real = fileInputStream2.read(buffer);
                fileOutputStream.write(buffer, 0, real);
            }
            fileOutputStream.write(buffer1);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
/*
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (FileInputStream fileInputStream1 = new FileInputStream(fileName1);
             FileInputStream fileInputStream2 = new FileInputStream(fileName2)) {

            while (fileInputStream2.available() > 0) {
                byteArrayOutputStream.write(fileInputStream2.read());
            }
            while (fileInputStream1.available() > 0) {
                byteArrayOutputStream.write(fileInputStream1.read());
            }
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName1)) {
            byteArrayOutputStream.writeTo(fileOutputStream);
        }
    }
 */