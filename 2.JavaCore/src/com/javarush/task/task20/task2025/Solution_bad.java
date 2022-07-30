package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_bad {
    public static long[] getNumbers(long N) {
        long[] result;
        List<Long> res = new ArrayList<>();

        for (long i = 0; i < N; i++) {
            if (i < 10) {
                res.add( i);
            } else {
                String num = Long.toString(i);
                Long num_= 0L;
                int steps = num.length();
                for (int j = 0; j < steps; j++) {
                    long part = Long.parseLong(String.valueOf(num.charAt(j)));
                    Long mult = 1L;
                    for (int k = 0; k < steps; k++) {
                        mult*=part;
                    }
                    num_+=mult;
                }
                if (i == num_){
                    res.add(i);
                }
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
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(100000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}

