package com.javarush.task.task30.task3010;

/*
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int i = 2;
        BigInteger number = null;
        while (i <= 36) {
            try {
                number = new BigInteger(args[0], i);
            } catch (Exception ignored) {
            }
            if (number != null) {
                break;
            }
            i++;
        }

        if (number != null) {
            System.out.println(i);
        } else {
            System.out.println("incorrect");
        }
    }
}