package com.javarush.task.pro.task13.task1315;

/* 
Четыре сезона
*/


public class Solution {

    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.WINTER);

        Season[] seasons = Season.values();

        for (Season season : seasons)
            System.out.println(season);


        System.out.println(Season.WINTER.ordinal());
        System.out.println(Season.AUTUMN.ordinal());
        System.out.println(Season.SPRING.ordinal());
    }
}
