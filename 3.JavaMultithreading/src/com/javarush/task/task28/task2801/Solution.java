package com.javarush.task.task28.task2801;

/* 
Осваиваем switch
*/

public class Solution {

    public static enum E1 {A, B, C, Y}

    public static enum E2 {D, E, F}

    public static enum E3 {D, E, F}

    public static void main(String[] args) {
        Solution.switchTest(E1.C);
        Solution.switchTest(E3.D);
        Solution.switchTest(E2.D);
        /* output
        it's E1.C
        undefined
        it's E2.D
         */
    }

    public static void switchTest(Enum obj) {
        //add your code here
        String name = obj.getClass().getSimpleName();
        switch (name){
            case "E1":
                System.out.printf("it's E1.%s%n", obj.name());
                break;
            case "E2":
                System.out.printf("it's E2.%s%n", obj.name());
                break;
            default:
                System.out.println("undefined");
        }

//        if (obj.equals(E1.A) || obj.equals(E1.B) || obj.equals(E1.C) || obj.equals(E1.Y)) {
//            System.out.printf("it's E1.%s%n", obj.name());
//        } else if (obj.equals(E2.D) || obj.equals(E2.E) || obj.equals(E2.F)) {
//            System.out.printf("it's E2.%s%n", obj.name());
//        } else {
//            System.out.println("undefined");
//        }
    }
}
