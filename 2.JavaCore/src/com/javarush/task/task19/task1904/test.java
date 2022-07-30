package com.javarush.task.task19.task1904;

import java.util.Date;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner("/Users/denis/Downloads/test.txt");

        String[] person = sc.nextLine().split(" ");
        for (String s: person) {
            System.out.println(s);
        }
//        String lastName = sc.next();
//        String firsName = sc.next();
//        String middleName = sc.next();
//
//        int day = sc.nextInt();
//        int month = sc.nextInt();
//        int year = sc.nextInt();
//        Date birthDate = new Date(year-1900, month-1, day);
//        String out =String.format("%s %s %s %s",firsName,middleName,lastName,birthDate);
//        System.out.println(out);
    }
}
