package com.javarush.task.pro.task08.task0810;

import java.util.concurrent.TimeUnit;

/* 
Таймер
*/

public class Solution {

    public static void setTimer(int days, int hours, int minutes, int seconds, int millis) throws InterruptedException {
        System.out.println("Таймер запущен!");
        if (days > 0) TimeUnit.DAYS.sleep(days);
        if (hours > 0) TimeUnit.HOURS.sleep(hours);
        if (minutes > 0) TimeUnit.MINUTES.sleep(minutes);
        if (seconds > 0) TimeUnit.SECONDS.sleep(seconds);
        if (millis > 0) TimeUnit.MILLISECONDS.sleep(millis);
        System.out.println("♬ ♪ ♬♬♬♬ ♪♪♪♪");
    }
}
