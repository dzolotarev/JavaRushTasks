package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {

        String query = "level22.lesson13.task01";
        String delimiter = ".";
        System.out.println(getTokens(query, delimiter).toString());

    }

    public static String[] getTokens(String query, String delimiter) {
        ArrayList<String> tmp = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        while (stringTokenizer.hasMoreTokens()) {
            tmp.add(stringTokenizer.nextToken());
        }

        String[] arr = tmp.toArray(new String[tmp.size()]);


        return arr;
    }
}
