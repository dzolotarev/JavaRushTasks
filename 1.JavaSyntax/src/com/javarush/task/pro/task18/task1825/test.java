package com.javarush.task.pro.task18.task1825;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class test {
    public static void main(String[] args) {
        String[] array1 = {"мама", "мыла", "раму"};
        String[] array2 = {"я", "очень", "люблю", "java"};
        String[] array3 = {"мир", "труд", "май"};

        List<String[]> arrays = new ArrayList<>();
        arrays.add(array1);
        arrays.add(array2);
        arrays.add(array3);

        Comparator<String[]> sortByLength = (o1, o2) -> o1.length - o2.length;


        arrays.sort((o1, o2) -> {
            int length1 = 0;
            int length2 = 0;
            for (String s : o1) {
                length1 += s.length();
            }
            for (String s : o2) {
                length2 += s.length();
            }
            return length1 - length2;
        });
    }
    int counter = 0;
    Runnable r = () -> counter++;
}
