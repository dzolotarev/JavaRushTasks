package com.javarush.task.task19.task1908;

import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        System.out.println(Pattern.matches("^\\d+$", "12"));
        System.out.println(Pattern.matches("^\\d+$", "text"));
        System.out.println(Pattern.matches("^\\d+$", "var2"));
        System.out.println(Pattern.matches("^\\d+$", "14"));
        System.out.println(Pattern.matches("^\\d+$", "8ю"));
        System.out.println(Pattern.matches("^\\d+$", "1"));
    }
}