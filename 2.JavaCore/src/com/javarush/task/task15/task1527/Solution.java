package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();


        String splitedString = url.substring(url.indexOf("?") + 1);

        String[] arrayOfSplits = splitedString.split("&");
        StringJoiner joiner = new StringJoiner(" ");
        String val = null;
        for (int i = 0; i < arrayOfSplits.length; i++) {
            StringBuilder prmval = new StringBuilder(arrayOfSplits[i]);
            if (prmval.indexOf("=") >= 0) {
                joiner.add(prmval.substring(0, prmval.indexOf("=")));
                if (arrayOfSplits[i].contains("obj")) {
                    val = prmval.substring(prmval.indexOf("=") + 1, prmval.length());
                }
            } else {
                joiner.add(prmval.toString());
            }
        }
        System.out.println(joiner);
        if (!(val == null)){
            try {
                alert(Double.parseDouble(val));
            } catch (Exception e) {
                alert(val);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
