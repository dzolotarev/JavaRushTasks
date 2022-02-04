package com.javarush.task.pro.task05.task0514;

import java.util.Arrays;

/* 
Выводим двумерные массивы
*/

public class Solution {

    public static String[][] strings = new String[][]{{"🙂", "🙂", "🙂", "🙂"}, {"🙃", "🙃", "🙃", "🙃"}, {"😋", "😋", "😋", "😋"}, {"😎", "😎", "😎", "😎"}};
    public static int[][] ints = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

    public static void main(String[] args) {
        String _str = Arrays.deepToString(strings);
        String _ints = Arrays.deepToString(ints);
        System.out.println(_str);
        System.out.println(_ints);
    }
}
