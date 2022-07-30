package com.javarush.task.task20.task2026;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int requiredElement = 14;
        int[] array = {0, 14, 30, 14, 11, 1, 4, 5, 7, 8, 9, 0};
        System.out.println(binarySearch(array,requiredElement));


    }

    public static int binarySearch(int[] array, int requiredElement) {
        int l = 0;
        int r = array.length - 1;
        int[] sortedArray = Arrays.stream(array).sorted().toArray();
        while (l <= r) {
            int m = l + (r - l)/2;
            int element = sortedArray[m];
            if (element == requiredElement) {
                return m;
            }
            if (element < requiredElement) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }
}
