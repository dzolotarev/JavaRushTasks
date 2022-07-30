package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) {
        String filePath1="";
        String filePath2="";
        String filePath3="";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            filePath1 = reader.readLine();
            filePath2 = reader.readLine();
            filePath3 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(FileOutputStream fileOutputStream1 = new FileOutputStream(filePath1); FileInputStream fileInputStream1 = new FileInputStream(filePath2)){

                byte[] buffer = new byte[65536];
                while (fileInputStream1.available() > 0)
                {
                    int real = fileInputStream1.read(buffer);
                    fileOutputStream1.write(buffer, 0, real);
                }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileOutputStream fileOutputStream1 = new FileOutputStream(filePath1,true); FileInputStream fileInputStream1 = new FileInputStream(filePath3)){

            byte[] buffer = new byte[65536];
            while (fileInputStream1.available() > 0)
            {
                int real = fileInputStream1.read(buffer);
                fileOutputStream1.write(buffer, 0, real);
            }
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
        String fileName3 = reader.readLine();

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName1);
             FileInputStream fileInputStream1 = new FileInputStream(fileName2);
             FileInputStream fileInputStream2 = new FileInputStream(fileName3)) {
            while (fileInputStream1.available() > 0) {
                fileOutputStream.write(fileInputStream1.read());
            }
            while (fileInputStream2.available() > 0) {
                fileOutputStream.write(fileInputStream2.read());
            }
        }
    }
}
 */