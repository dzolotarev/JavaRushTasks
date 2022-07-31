package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
        System.out.println(getPartOfString("   "));
    }

    public static String getPartOfString(String string) {
        if (string == null || string.isEmpty()) {
            throw new TooShortStringException();
        }
        String[] splintedString = string.trim().split(" ");
        String result;
        try{
            result = String.format("%s %s %s %s", splintedString[1], splintedString[2], splintedString[3],splintedString[4]);
        } catch (Exception e){
            throw new TooShortStringException();
        }

        return result;
    }

    public static class TooShortStringException extends RuntimeException {

    }

}
