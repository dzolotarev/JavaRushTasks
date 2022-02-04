package com.javarush.task.pro.task08.task0803;

import java.util.Random;

public class Main1 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getRandomDiceNumber());
        }
    }

    public static int getRandomDiceNumber() {
        Random r = new Random();
        int x = r.nextInt(100);
        return x;

    }

}
