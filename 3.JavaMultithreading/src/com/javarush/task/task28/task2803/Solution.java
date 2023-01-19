package com.javarush.task.task28.task2803;

import java.util.concurrent.ThreadLocalRandom;

/* 
ThreadLocalRandom
*/

public class Solution {
    public static int getRandomIntegerBetweenNumbers(int from, int to) {
        int value = ThreadLocalRandom.current().nextInt(from,to);
        return value;
    }

    public static double getRandomDouble() {
        double value = ThreadLocalRandom.current().nextDouble();
        return value;
    }

    public static long getRandomLongBetween0AndN(long n) {
        long value = ThreadLocalRandom.current().nextLong(0,n);
        return value;
    }

    public static void main(String[] args) {
    }
}
