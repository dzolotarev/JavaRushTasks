package com.javarush.task.task13.task1326;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileUrl = scanner.nextLine();

        FileInputStream input = new FileInputStream(fileUrl);
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader buffer = new BufferedReader(reader);

        List<Integer> myList = new ArrayList<>();
        String line;
        while ((line = buffer.readLine()) != null) {
            myList.add(Integer.parseInt(line));
        }
        Collections.sort(myList);
        for (Integer s : myList) {
            if (s % 2 == 0) System.out.println(s);
        }
        buffer.close();
    }
}
