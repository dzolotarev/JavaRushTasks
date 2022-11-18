package com.javarush.task.task26.task2601;

/*
Почитать в инете про медиану выборки
*/

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
/*
для тестиков ЧЁТНЫЕ :
[13, 8, 15, 5, 18, 11]   ->[11, 13, 15, 8, 18, 5]
[10,20,20,30,20,50,60,22] ->[20, 20, 20, 22, 30, 10, 50, 60]
НЕЧЁТНЫЕ:
[10, 8, 12, 6, 19 ] ->[10, 8, 12, 6, 19]
[11, 3, 122, 36, 18,0,1]->[11, 18, 3, 1, 0, 36, 122]
 */
//        //Integer[] array = {11, 3, 122, 36, 18,0,1};
//        Integer[] array = {10, 8, 12, 6, 19};
//        //Integer[] array = {10,20,20,30,20,50,60,22};
//        //Integer[] array = {13, 8, 15, 5, 18, 11};
//        //Integer[] array = {13, 8, 15, 5, 17,19};
//        //Integer[] array = {3, 7, 1, 6, 9};
//        System.out.print("Before: ");
//        for (Integer integer : array) {
//            System.out.printf("%d ", integer);
//        }
//        sort(array);
//        System.out.print("\nAfter: ");
//        for (Integer integer : array) {
//            System.out.printf("%d ", integer);
//        }
    }


    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        double median = array.length % 2 == 0 ? (array[array.length / 2] + array[array.length / 2 - 1]) / 2 : array[(array.length) / 2];

        Comparator<Integer> compareByMedian = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                double d1 = Math.abs(o1 - median);
                double d2 = Math.abs(o2 - median);
                return (d1 - d2) < 0 ? -1 : d1 - d2 == 0 ? 0 : 1;
//                double v1 = o1.intValue() - median;
//                double v2 = o2.intValue() - median;
//                return (int) ((v1 * v1 - v2 * v2) * 100);
            }
        };
        Arrays.sort(array, compareByMedian);

        return array;
    }

//    private static Integer[] sortArray(Integer[] values) {
//        int i, j, temp;
//        for (i = 0; i < values.length - 1; i++) {
//            for (j = i + 1; j < values.length; j++) {
//                if (values[i] > values[j]) {
//                    temp = values[i];
//                    values[i] = values[j];
//                    values[j] = temp;
//                }
//            }
//        }
//        return values;
//    }

    private static double getMedian(Integer[] values) {
        double median;
        if (values.length % 2 == 0) {
            median = (values[values.length / 2] + values[values.length / 2 - 1]) / 2.0;
        } else {
            median = values[(values.length) / 2];
        }
        return median;
    }

}
