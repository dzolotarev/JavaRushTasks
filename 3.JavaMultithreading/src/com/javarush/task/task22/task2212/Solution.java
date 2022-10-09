package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        //wrong regex "^\+?(\d[\(\)]?){9,11}\d$"

        if (telNumber==null || telNumber.equals("")){
            return false;
        }
       // else if (telNumber.matches("^\\+\\d{12}$|^\\+\\d+\\(\\d{3}\\)\\d+$|^\\(\\d{3}\\)\\d+$|^\\d+\\(\\d{3}\\)\\d+$|^\\d{10}$")) { //#1 try
        //----N2 try
//        else if (telNumber.matches("^\\+\\d{12}$|^\\+\\d{1,8}\\(\\d{3}\\)\\d{1,8}$|^\\(\\d{3}\\)\\d{7}$|^\\d{1,6}\\(\\d{3}\\)\\d{1,6}$|^\\d{10}$")) {
//            return true;
//        } else return false;
        //------end N2
        return (telNumber.matches("^\\+(\\d[()]?){12}$") || telNumber.matches("^([()]?\\d){10}$"))
                && telNumber.matches("^(\\+)?(\\d+)?(\\(\\d{3}\\))?\\d+$");


                // wrong // || telNumber.matches("^\\(\\d{3}\\)\\d{7}$") || telNumber.matches("^\\d{1,6}\\(\\d{3}\\)\\d{1,6}$") || telNumber.matches("^\\+\\d{1,8}\\(\\d{3}\\)\\d{1,8}$");
    }

    public static void main(String[] args) {
        System.out.println("+38050123467a " +checkTelNumber("+38050123467a"));

        System.out.println("+380501234567 " + checkTelNumber("+380501234567"));
        System.out.println("+38(050)1234567 " +checkTelNumber("+38(050)1234567"));
        System.out.println("(050)1234567 " + checkTelNumber("(050)1234567"));
        System.out.println("0(501)234567 " +checkTelNumber("0(501)234567"));
        System.out.println("0(501)2345678 " +checkTelNumber("0(501)2345678"));
        System.out.println("+38)050(1234567 " +checkTelNumber("+38)050(1234567"));
        System.out.println("+38(050)123-45-67 " +checkTelNumber("+38(050)123-45-67"));
        System.out.println("050ххх4567 " + checkTelNumber("050ххх4567"));
        System.out.println("050123456 " + checkTelNumber("050123456"));
        System.out.println("(0)501234567 " +checkTelNumber("(0)501234567"));

        System.out.println("+380501234567 - true = " + checkTelNumber("+380501234567"));
        System.out.println("+3805012345673 - false = " + checkTelNumber("+3805012345673"));
        System.out.println("+38050123456 - false = " + checkTelNumber("+38050123456"));
        System.out.println("+38(050)1234567 - true = " + checkTelNumber("+38(050)1234567"));
        System.out.println("(050)1234567 - true = " + checkTelNumber("(050)1234567"));
        System.out.println("0(501)234567 - true = " + checkTelNumber("0(501)234567"));
        System.out.println("+38)050(1234567 - false = " + checkTelNumber("+38)050(1234567"));
        System.out.println("+38(050)123-45-67 - false = " + checkTelNumber("+38(050)123-45-67"));
        System.out.println("050ххх4567 - false = " + checkTelNumber("050ххх4567"));
        System.out.println("050123456 - false = " + checkTelNumber("050123456"));
        System.out.println("(0)501234567 - false = " + checkTelNumber("(0)501234567"));
        System.out.println("123456789012 - false = " + checkTelNumber("123456789012"));
        System.out.println("123(456)7890 - true = " + checkTelNumber("123(456)7890"));
        System.out.println("123456(789)0 - true = " + checkTelNumber("123456(789)0"));
        System.out.println("+123(456)789012 - true = " + checkTelNumber("+123(456)789012"));
        System.out.println("+123456(789)012 - true = " + checkTelNumber("+123456(789)012"));
        System.out.println("+123456789(456) - false = " + checkTelNumber("+123456789(456)"));
        System.out.println("Проверка на пустую строку \"\" - false = " + checkTelNumber(""));
        System.out.println("Проверка на null - false =  " + checkTelNumber(null));

    }
}
