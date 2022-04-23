package com.javarush.task.task15.task1515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Статики-2
*/

public class Solution {
    public static int A;
    public static int B;

    static {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String temp1, temp2;
            temp1 = reader.readLine();
            A= Integer.parseInt(temp1);
            temp2 = reader.readLine();
            B= Integer.parseInt(temp2);
            reader.close();

        } catch (IOException e) {
            System.out.println("Ошибка! Перехвачено исключение");
        }
    }

    public static final int MIN = min(A, B);

    public static void main(String[] args) {
        System.out.println(MIN);
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}
