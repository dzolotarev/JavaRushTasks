package com.javarush.task.task19.task1903;

import java.text.DecimalFormat;

public class test {

    public static void main(String[] args) {
        DecimalFormat phoneDecimalFmt = new DecimalFormat("0000000000");
        String phoneRawString = phoneDecimalFmt.format(501234567);
        String country = "38";
        String code = phoneRawString.substring(0, 3);
        String first = phoneRawString.substring(3, 6);
        String second = phoneRawString.substring(6, 8);
        String third = phoneRawString.substring(8, 10);


        String finalNumber = String.format("+%s(%s)%s-%s-%s", country, code, first, second, third);
        System.out.println(finalNumber);
    }
}
