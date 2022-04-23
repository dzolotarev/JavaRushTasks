package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        FileInputStream input = new FileInputStream(str);
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader reader1 = new BufferedReader(reader);
        while (reader1.ready())
        {
           int line = reader.read();
           System.out.print((char) line);
        }
        scanner.close();
        reader1.close();
        reader.close();
    }
}