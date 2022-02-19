package com.javarush.task.pro.task16.task1604;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(1983, Calendar.AUGUST, 24);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String weekStr = "";
        switch (dayOfWeek){
            case 1: weekStr = "Воскресенье";
                break;
            case 2: weekStr = "Понедельник";
                break;
            case 3: weekStr = "Вторник";
                break;
            case 4: weekStr = "Среда";
                break;
            case 5: weekStr = "Четверг";
                break;
            case 6: weekStr = "Пятница";
                break;
            case 7: weekStr = "Суббота";
                break;


        }
        return weekStr;
    }
}
