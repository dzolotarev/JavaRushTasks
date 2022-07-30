package com.javarush.task.task20.task2025;

import java.util.Scanner;

public class MyNewTest2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            int i = scanner.nextInt();
            if (i > 0 && i % 2 == 0) {
                System.out.println("compassion");
            } else if (i < 0 && i % 2 == 0) {
                System.out.println("mercy");
            } else if (i > 0 && i % 2 != 0) {
                System.out.println("pain");
            } else if (i < 0 && i % 2 != 0) {
                System.out.println("anger");
            } else {
                System.out.println("balance");
            }
        }


    }

}
