package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream defaultStream = System.out;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
        testString.printSomething();
        System.setOut(defaultStream);

        String[] splited = stream.toString().split("\\s");
        int result = 0;
        switch (splited[1]) {
            case ("+"):
                result = Integer.parseInt(splited[0]) + Integer.parseInt(splited[2]);
                break;
            case ("-"):
                result = Integer.parseInt(splited[0]) - Integer.parseInt(splited[2]);
                break;
            case ("*"):
                result = Integer.parseInt(splited[0]) * Integer.parseInt(splited[2]);
        }


        System.out.printf("%s %s %s %s %d", splited[0], splited[1], splited[2], splited[3], result);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

