package com.javarush.task.task20.task2025;


import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {

        long[] array = digitazer(123);
        int k = array.length;
        permutation(array,k);

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
            int number = 0;
            for (int i = 0; i < array.length; i++) {
                number += array[array.length - 1 - i] * (int) Math.pow(10, i);
            }
            System.out.println(number);
            //System.out.println(Arrays.toString(array));
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


}
