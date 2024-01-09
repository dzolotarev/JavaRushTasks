//package com.javarush.task.task38.task3808;
//
//import java.util.ArrayList;
//import java.util.List;
//
///*
//Неверные аннотации
//*/
//
//public class Solution_origin {
//    @Main
//    public static void main(String[] args) {
//        Solution_origin solution = new Solution_origin().new SubSolution();
//        solution.overriddenMethod();
//    }
//
//    public void overriddenMethod() {
//    }
//
//    public class SubSolution extends Solution_origin {
//        @SafeVarargs
//        public void overriddenMethod() {
//            System.out.println(uncheckedCall());
//        }
//
//        @Override
//        List uncheckedCall() {
//            List list = new ArrayList();
//            list.add("hello");
//            return list;
//        }
//    }
//
//
//}
