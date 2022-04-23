package com.javarush.task.task16.task1632;

public class Class2 extends Thread {
    private int count = 0;

    public void run() {
        while (true)
            try {
                count++;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
    }
}

