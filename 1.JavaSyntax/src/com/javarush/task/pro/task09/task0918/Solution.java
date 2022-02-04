package com.javarush.task.pro.task09.task0918;

/* 
Поработаем со StringBuilder
*/

public class Solution {
    public static void main(String[] args) {
        String string = "Учиться, учиться и еще раз учиться! ";

        System.out.println(addTo(string, new String[]{"Под ", "лежачий ", "камень ", "вода ", "не ", "течет"}));
        System.out.println(replace(string, ", ", 16, 27));
    }

    public static StringBuilder addTo(String string, String[] strings) {
        StringBuilder resultString = new StringBuilder(string);
        for (int i = 0; i < strings.length; i++) {
            resultString = resultString.append(strings[i]);
        }
        return resultString;
    }

    public static StringBuilder replace(String string, String str, int start, int end) {
        StringBuilder resultString = new StringBuilder(string);
        resultString = resultString.replace(start, end, str);
        return resultString;
    }
}
