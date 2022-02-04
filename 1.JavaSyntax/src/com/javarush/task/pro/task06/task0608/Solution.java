package com.javarush.task.pro.task06.task0608;

/* 
Кубический калькулятор
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(cube(2));
    }

    public static long cube(long value) {
        //return (value * value * value);
        return (long) Math.pow(value, 3);
    }
}
