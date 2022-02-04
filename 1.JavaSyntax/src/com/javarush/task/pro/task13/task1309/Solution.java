package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("Иван Иванов", 4.75d);
        grades.put("Александр Александров", 4.05d);
        grades.put("John Doe",3.75d);
        grades.put("Corben Dallas", 2.95d);
        grades.put("Алиса Селезнева", 4.95d);
    }
}
