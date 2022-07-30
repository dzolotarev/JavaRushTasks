package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

//        int count1 = getRectangleCount(a1);
//        System.out.println("count = " + count1 + ". Должно быть 2");
//        int count2 = getRectangleCount(a2);
//        System.out.println("count = " + count2 + ". Должно быть 4");
        //findCoordinates(a1);
        findCoordinates(a2);
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;

        return count;
    }

    public static void findCoordinates(byte[][] a) {
        int y = 0, x = 0;
        int stepX = 0;

//y < a.length
        while (true) {
            if (a[y][x] == 1) {
                x++;
                stepX++;
                System.out.print(" * ");
            } else {
                if (y < a.length-1) {
                    System.out.println();
                    y++;
                    x = x - stepX;
                    stepX = 0;
                } else {
                    x++;
                    y=0;
                }


            }
        }
    }

}
