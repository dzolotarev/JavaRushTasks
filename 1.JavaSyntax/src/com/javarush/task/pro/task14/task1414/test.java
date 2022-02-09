package com.javarush.task.pro.task14.task1414;

import java.util.Stack;

public class test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(15);
        System.out.println(stack.search(15));
        System.out.println(stack.pop());
        System.out.println(stack.search(15));
    }
}
