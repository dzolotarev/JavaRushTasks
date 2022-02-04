package com.javarush.task.pro.task09.task0908;

import java.util.regex.Pattern;

public class TestPattern {
    public static void main(String[] args) {
        String s = "020011100101010101";
        if (Pattern.compile("[01]+").matcher(s).matches() != true ){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
//        if (s.matches("[01]*")){
//            System.out.println("YES");
//        }
    }
}
