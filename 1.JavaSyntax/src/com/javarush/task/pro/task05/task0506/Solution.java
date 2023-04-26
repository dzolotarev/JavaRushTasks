package com.javarush.task.pro.task05.task0506;

import java.util.Scanner;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static int[] array;

    public static void main(String[] args) throws Exception {
       
       Scanner _n = new Scanner(System.in);
        int n = _n.nextInt();
        Scanner console = new Scanner(System.in);
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = console.nextInt();
        }
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        System.out.println(min);
    }
}