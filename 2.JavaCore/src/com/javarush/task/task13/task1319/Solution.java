package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileUrl = scanner.nextLine();

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writter = new BufferedWriter(new FileWriter(fileUrl));

        String line = null;

        do {
            line = buff.readLine();
            writter.write(line+ "\n");
        } while (!line.equals("exit"));



        buff.close();
        writter.close();
    }
}
