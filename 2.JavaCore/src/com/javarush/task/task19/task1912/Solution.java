package com.javarush.task.task19.task1912;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ридер обертка 2
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream defaultStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream newPrintStream = new PrintStream(outputStream);
        System.setOut(newPrintStream);
        testString.printSomething();
        System.setOut(defaultStream);

        String result = outputStream.toString();

        Pattern pattern = Pattern.compile("te");
        Matcher matcher = pattern.matcher(result);
        String resolve = matcher.replaceAll("??");
        System.out.println(resolve);
        
        /* без использования matcher и pattern
         result = result.replaceAll("te", "??");
         */



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
