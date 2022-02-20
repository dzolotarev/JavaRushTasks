package com.javarush.task.pro.task16.task1621;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/* 
Напиши шаблон
*/

public class Solution {

    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
    static String timeString = "13:30:45 23/02/2019";

    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.parse(timeString, dateTimeFormatter);
        System.out.println(dateTime);
//        LocalDateTime shanghai = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
//        System.out.println(shanghai);
//        System.out.println(shanghai.getMonth());
//        System.out.println(shanghai.getMonthValue());
    }
}
