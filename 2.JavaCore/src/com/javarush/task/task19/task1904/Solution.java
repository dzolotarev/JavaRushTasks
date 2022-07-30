package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }


        @Override
        public Person read() throws IOException {
            String[] person = fileScanner.nextLine().split(" ");
            String lastName = person[0];
            String firsName = person[1];
            String middleName = person[2];
            int day = Integer.parseInt(person[3]);
            int month = Integer.parseInt(person[4]);
            int year = Integer.parseInt(person[5]);




//            String lastName = fileScanner.next();
//            String firsName = fileScanner.next();
//            String middleName = fileScanner.next();
//            int day = fileScanner.nextInt();
//            int month = fileScanner.nextInt();
//            int year = fileScanner.nextInt();
            Date birthDate = new Date(year-1900, month-1, day);
            return new Person(firsName, middleName, lastName, birthDate);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
