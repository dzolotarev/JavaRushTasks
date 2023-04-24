package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.LinkedList;

import static java.lang.Math.abs;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
        solution.createExpression(1234);
        solution.createExpression(2);
        solution.createExpression(730);
        solution.createExpression(728);
        solution.createExpression(- 1024);
        solution.createExpression(- 10024);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        LinkedList<Integer> list = new LinkedList<>();

//        do {
//            int s = number > 0 ? 1 : -1;
//            number = abs(number);
//            int sum = 1, p = 1;
//            while (sum < number) {
//                sum += (p *= 3);
//            }
//            int tempResult = stack.push(s * p);
//            System.out.println(tempResult);
//            number = s * (number - p);
//        } while (number <= 0);

        decompose(number, list);
        StringBuilder stringBuilder = new StringBuilder(number + " =");
        for (Integer integer : list) {
            if (integer > 0) {
                stringBuilder.append(" + ").append(integer);
            } else {
                stringBuilder.append(" - ").append(abs(integer));
            }
        }
        System.out.println(stringBuilder);
    }

    private void decompose(int m, LinkedList<Integer> list) {
        int s = m > 0 ? 1 : -1;
        m = abs(m);
        int sum = 1, p = 1;
        while (sum < m) {
            sum += (p *= 3);
        }
        list.addFirst(s * p);
        if (m != p) {
            decompose(s * (m - p), list);
        }
    }
}