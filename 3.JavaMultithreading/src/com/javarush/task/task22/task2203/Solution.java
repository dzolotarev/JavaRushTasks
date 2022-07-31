package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null || string.isEmpty()) {
            throw new TooShortStringException();
        }
        int firstTabIndex = string.indexOf('\t');
        int lastTabIndex = string.lastIndexOf('\t');
        if (firstTabIndex+1 == lastTabIndex||firstTabIndex == lastTabIndex) {
            throw new TooShortStringException();
        }
        int secondTabIndex = string.indexOf('\t',firstTabIndex+1);


        return string.substring(firstTabIndex+1,secondTabIndex);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
        System.out.println(getPartOfString("\tобучения Java."));
    }
}


///*
//Между табуляциями #2
//*/
//
//public class Solution {
//    public static void main(String[] args) throws Exception {
//        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
//    }
//
//    public static String getPartOfString(String string) throws TooShortStringException {
//        if (string == null) {
//            throw new TooShortStringException();
//        }
//        String[] splitWithTabs = string.split("\\t");
//
//        if (splitWithTabs.length < 3) throw new TooShortStringException();
//
//        return splitWithTabs[1];
//    }
//
//    public static class TooShortStringException extends Exception {
//    }
//}

