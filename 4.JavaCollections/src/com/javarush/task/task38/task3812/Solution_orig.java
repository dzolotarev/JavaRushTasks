package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

public class Solution_orig {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution_orig.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution_orig.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        return true;
    }

    public static boolean printValues(Class c) {
        return true;
    }
}
