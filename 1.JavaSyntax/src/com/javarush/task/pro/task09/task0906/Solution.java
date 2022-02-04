package com.javarush.task.pro.task09.task0906;

import java.util.regex.Pattern;

/*
Двоичный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = Integer.MAX_VALUE;
        System.out.println("Десятичное число " + decimalNumber + " равно двоичному числу " + toBinary(decimalNumber));
        String binaryNumber = "1111111111111111111111111111111";
        System.out.println("Двоичное число " + binaryNumber + " равно десятичному числу " + toDecimal(binaryNumber));
    }

    public static String toBinary(int decimalNumber) {
        String binaryNumber = "";
        if (decimalNumber <= 0) {
            return binaryNumber;
        }
        while (decimalNumber > 0) {
            binaryNumber = decimalNumber % 2 + binaryNumber;
            decimalNumber = decimalNumber / 2;
        }
        return binaryNumber;
    }

    public static int toDecimal(String binaryNumber) {
        if (binaryNumber == null || binaryNumber.equals("")) {
            return 0;
        }
        String[] charNum = binaryNumber.split("");
        int[] binaryNumberz = new int[charNum.length];
        int decimalNumber = 0;
        for (int i = 0; i < charNum.length; i++) {
            if (charNum[charNum.length - 1 - i].equals("1")) binaryNumberz[i] = 1;
            else binaryNumberz[i] = 0;
            decimalNumber += binaryNumberz[i] * Math.pow(2, i);
        }
        return decimalNumber;
    }
}
