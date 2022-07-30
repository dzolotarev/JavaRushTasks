package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Алгоритмы-числа
*/


public class Solution_old {
    private static long[][] powMatrix;

    static {
        powMatrix = new long[11][20];
        for (int i = 0; i < powMatrix.length; i++) {
            long p = 1;
            for (int j = 0; j < powMatrix[i].length; j++) {
                powMatrix[i][j] = p;
                p *= i;
            }
        }
    }

    public static long[] getNumbers(long N) {

        long[] result;
        List<Long> res = new ArrayList<>();
        for (long k = 0; k < N; k++) {
            int digits = 0;

            long sum = 0;
            long currentNumber = k;
            while (currentNumber != 0) {
                currentNumber /= 10;
                ++digits;
            }
            currentNumber = k;
            while (currentNumber != 0) {
                long reminder = currentNumber % 10;
                sum += powMatrix[(int) reminder][digits];
                currentNumber /= 10;
            }
            if (sum == 0) continue;
            if (sum == k) {
                res.add(k);
            }
        }

        result = new long[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
//        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
//        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
//        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();

        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) + " ms");
    }
}
