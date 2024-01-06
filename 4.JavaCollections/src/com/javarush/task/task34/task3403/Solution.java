package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/

public class Solution {
    public void recurse(int n) {
        if (n <= 1) {
            System.out.println();
            return;
        }
        if (n % 2 == 0) {
            System.out.print("2 ");
            recurse(n / 2);
        } else if (n % 3 == 0) {
            System.out.print("3 ");
            recurse(n / 3);
        } else if (n % 5 == 0) {
            System.out.print("5 ");
            recurse(n / 5);
        } else if (n % 7 == 0) {
            System.out.print("7 ");
            recurse(n / 7);
        } else
            System.out.println(n);
    }

    //Очень странное решение от JR
    public void recurse2(int n) {
        if (n <= 1) return;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                recurse(n / i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse(132);
        solution.recurse(14);
        solution.recurse(1456);
        solution.recurse(5677288);
    }
}
