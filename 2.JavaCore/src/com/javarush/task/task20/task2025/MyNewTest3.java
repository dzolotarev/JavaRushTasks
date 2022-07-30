package com.javarush.task.task20.task2025;

import java.util.Scanner;

public class MyNewTest3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();


        for (int i = x; i >0 ; i--) {
            System.out.println();
            for (int j = y; j >0 ; j--) {
                System.out.print(" * ");
            }

        }


    }
}
