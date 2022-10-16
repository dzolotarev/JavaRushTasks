package com.javarush.task.task23.task2305;

/* 
Inner
*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution solution = new Solution();
        Solution solution1 = new Solution();
        Solution.InnerClass innerClass = solution.new InnerClass();
        Solution.InnerClass innerClass2 = solution.new InnerClass();
        solution.innerClasses[0]=innerClass;
        solution.innerClasses[1]=innerClass2;

        Solution.InnerClass innerClass1 = solution1.new InnerClass();
        Solution.InnerClass innerClass3 = solution1.new InnerClass();
        solution1.innerClasses[0]=innerClass1;
        solution1.innerClasses[1]=innerClass3;
        Solution[] solutions = new Solution[2];
        solutions[0]=solution;
        solutions[1]=solution1;

        return solutions;
    }

    public static void main(String[] args) {

    }
}
