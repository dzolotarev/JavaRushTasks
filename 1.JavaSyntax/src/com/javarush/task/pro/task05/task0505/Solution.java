package com.javarush.task.pro.task05.task0505;

import java.util.Scanner;

/* 
Reverse
*/

public class Solution {
    public static void main(String[] args) {

        Scanner _n = new Scanner(System.in);
        int n = _n.nextInt();
        if (n <= 0) {
            System.out.println("Введено отрицательное число! " + n);
            return;
        }
        Scanner console = new Scanner(System.in);
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = console.nextInt();
        }
        if (array.length % 2 == 0) {
            for (int i = array.length-1; i >= 0; i--) {
                System.out.println(array[i]);
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);
            }
        }
    }
}
