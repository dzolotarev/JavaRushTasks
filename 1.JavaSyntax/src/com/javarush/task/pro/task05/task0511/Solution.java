package com.javarush.task.pro.task05.task0511;

import java.util.Scanner;

/* 
Создаем двумерный массив
*/

public class Solution {
    public static int[][] multiArray;

    public static void main(String[] args) {
        Scanner _n = new Scanner(System.in);
        int n = _n.nextInt();
        if (n <= 0) {
            System.out.println("Введено отрицательное число! " + n);
            return;
        } else {
            multiArray = new int[n][];
        }

        Scanner console = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            multiArray[i] = new int[console.nextInt()];
        }

        for (int i = 0; i < multiArray.length; i++) {
            for (int j = 0; j < multiArray[i].length; j++)
                System.out.print( multiArray[i][j] + " " );
            System.out.println();
        }
    }
}

