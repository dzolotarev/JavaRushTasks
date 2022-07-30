package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/


public class Solution {
    private static final long[][] powMatrix;
    private static Set<Long> recurrence = new HashSet<>();

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

    public static long[] digitazer(long number) {

        ArrayList<Long> tmp = new ArrayList<>();
        if (number < 0) {
            System.out.println("Negative " + number);
        }
        if (number < 10) {
            return new long[]{number};
        }
        long r = number;
        while (r != 0) {
            long q = r % 10;
            r = r / 10;
            tmp.add(q);
        }

        long[] result = new long[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            result[tmp.size() - 1 - i] = tmp.get(i);
        }

        return result;
    }

    public static void permutation(long[] array, int k) {
        if (k == 1) {
            long number = 0;
            for (int i = 0; i < array.length; i++) {
                number += array[array.length - 1 - i] * powMatrix[10][i];
            }
            recurrence.add(number);
            return;
        }
        for (int i = 0; i < k; i++) {
            permutation(array, k - 1);
            if (k % 2 == 0) {
                long temp = array[i];
                array[i] = array[k - 1];
                array[k - 1] = temp;
            } else {
                long temp = array[0];
                array[0] = array[k - 1];
                array[k - 1] = temp;
            }

        }
    }


    public static long[] getNumbers(long N) {

        long[] result;
        int checkDigits = -1;
        List<Long> res = new ArrayList<>();
        for (long k = 0; k < N; k++) {
            if (recurrence.contains(k)) {
                continue;
            }
            int digits = 0;

            long sum = 0;
            long currentNumber = k;
            while (currentNumber != 0) {
                currentNumber /= 10;
                ++digits;
            }
            if (digits != checkDigits) {
                checkDigits = digits;
                recurrence = new HashSet<>();
            }
            currentNumber = k;
            while (currentNumber != 0) {
                long reminder = currentNumber % 10;
                sum += powMatrix[(int) reminder][digits];
                currentNumber /= 10;
            }
            if (sum == 0) continue;
            if (sum == k) {
                long[] array = digitazer(k);
                int length = array.length;
                permutation(array, length);
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

        System.out.println(Arrays.toString(getNumbers(1000000000L)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) + " ms");
    }
}
