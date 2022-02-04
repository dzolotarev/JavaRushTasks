package com.javarush.task.pro.task13.task1319;

/* 
Месяцы в сезоне
*/

public enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    public static Month[] getWinterMonths(){
        final Month[] array = {DECEMBER, JANUARY, FEBRUARY};
        return array;
    }

    public static Month[] getSpringMonths(){
        final Month[] array = {MARCH, APRIL, MAY};
        return array;
    }

    public static Month[] getSummerMonths(){
        final Month[] array = {JUNE, JULY, AUGUST};
        return array;
    }

    public static Month[] getAutumnMonths(){
        final Month[] array = {SEPTEMBER, OCTOBER, NOVEMBER};
        return array;
    }



}
