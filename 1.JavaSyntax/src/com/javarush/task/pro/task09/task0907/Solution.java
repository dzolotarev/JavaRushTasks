package com.javarush.task.pro.task09.task0907;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Pattern;

/* 
Шестнадцатеричный конвертер
*/

public class Solution {
    private static final String HEX = "0123456789abcdef";

    public static void main(String[] args) {
        int decimalNumber = 1256;
        System.out.println("Десятичное число " + decimalNumber + " равно шестнадцатеричному числу " + toHex(decimalNumber));
        String hexNumber = "4e8";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно десятичному числу " + toDecimal(hexNumber));
    }

    public static String toHex(int decimalNumber) {
        String hexNumber = "";
        if (decimalNumber <= 0) {
            return hexNumber;
        }
        String[] hexArray = HEX.split("");

        int i = 0;
        while (decimalNumber > 0) {
            hexNumber = hexArray[decimalNumber % 16] + hexNumber;
            decimalNumber = decimalNumber / 16;
            i++;
        }
        return hexNumber;
    }

    public static int toDecimal(String hexNumber) {
        if (hexNumber == null || hexNumber.equals("")) {
            return 0;
        }
        int decimalNumber = 0;
        String[] hexArray = HEX.split("");
        String[] hexNum = hexNumber.split("");
        for (int i = 0; i < hexNumber.length(); i++) {
            decimalNumber = 16 * decimalNumber + Arrays.binarySearch(hexArray, hexNum[i]);
        }
        return decimalNumber;
    }
}
