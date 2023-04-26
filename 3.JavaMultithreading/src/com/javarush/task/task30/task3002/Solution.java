package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код
        int res;
        if (s.charAt(0) == '0') {
            if (s.charAt(1) == 'x') {
                res = Integer.parseInt(s.substring(2), 16);
            } else if (s.charAt(1) == 'b') {
                res = Integer.parseInt(s.substring(2), 2);
            } else {
                res = Integer.parseInt(s.substring(1), 8);
            }
        } else {
            res = Integer.parseInt(s);
        }
        s = Integer.toString(res);
        return s;
    }
}
