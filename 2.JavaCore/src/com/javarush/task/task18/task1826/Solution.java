package com.javarush.task.task18.task1826;

/*
Шифровка
*/

import java.io.*;

public class Solution {
    public static int secret = 127;

    public static void main(String[] args) throws IOException {
        if (args[0].equals("-d")) {
            decryptFile(args[1], args[2]);

        } else if (args[0].equals("-e")) {
            encryptFile(args[1], args[2]);
        }


    }

    public static void decryptFile(String path1, String path2) throws IOException {

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path1), 200);
        FileOutputStream fileOutputStream = new FileOutputStream(path2);

        int i;

        while ((i = bufferedInputStream.read()) != -1) {
            int enc = (byte) (i ^ secret);
            fileOutputStream.write(enc);
        }
        fileOutputStream.close();
        bufferedInputStream.close();

    }

    public static void encryptFile(String path1, String path2) throws IOException {

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path1), 200);
        FileOutputStream fileOutputStream = new FileOutputStream(path2);

        int i;

        while ((i = bufferedInputStream.read()) != -1) {
            int dec = (byte) (i ^ secret);
            fileOutputStream.write(dec);
        }
        fileOutputStream.close();
        bufferedInputStream.close();
    }

}
