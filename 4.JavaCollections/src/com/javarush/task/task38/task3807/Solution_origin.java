package com.javarush.task.task38.task3807;

/* 
Предопределенные типы аннотаций (Predefined Annotation Types)
*/

public class Solution_origin {

    private String[] arguments;

    public Solution_origin(String... arguments) {
        this.arguments = arguments;
    }

    public void voidMethod() throws Exception {
    }

    public static void main(String[] args) throws Exception {
        new Solution_origin().new SubSolution().voidMethod();
    }

    class SubSolution extends Solution_origin {

        public void voidMethod() throws Exception {
            super.voidMethod();
        }
    }
}
