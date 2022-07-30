package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String file = reader.readLine();
        reader.close();

        PrintStream originalStream = System.out;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(stream);
        System.setOut(newStream);
        testString.printSomething();
        System.setOut(originalStream);
        System.out.println(stream.toString());
        FileOutputStream writer = new FileOutputStream(file);
        writer.write(stream.toByteArray());
        writer.close();

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

