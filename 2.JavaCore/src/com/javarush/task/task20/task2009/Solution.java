package com.javarush.task.task20.task2009;

import java.io.Serializable;

/* 
Как сериализовать static?
*/

public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;
    }

    public static void main(String[] args) {
        ClassWithStatic classWithStatic = new ClassWithStatic();
        classWithStatic.i = 5;
        classWithStatic.j = 7;
        System.out.println(classWithStatic.i);
        System.out.println(classWithStatic.j);

    }
}
