package com.javarush.task.pro.task16.task1607;

import java.time.LocalDate;

/* 
Освоение нового API
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(nowExample());
        System.out.println(ofExample());
        System.out.println(ofYearDayExample());
        System.out.println(ofEpochDayExample());
    }

    static LocalDate nowExample() {
        LocalDate current = LocalDate.now();
        return current;
    }

    static LocalDate ofExample() {
        LocalDate current = LocalDate.of(2020, 9, 12);
        return current;
    }

    static LocalDate ofYearDayExample() {
        LocalDate current = LocalDate.ofYearDay(2020, 256);
        return current;
    }

    static LocalDate ofEpochDayExample() {
        LocalDate current = LocalDate.ofEpochDay(18517L);
        return current;
    }
}
