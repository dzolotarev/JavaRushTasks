package com.javarush.task.task16.task1632;

public class Class4 extends Thread implements Message {
    private int count = 0;

    @Override
    public void showWarning() {
        this.interrupt();
        }


    public void run() {
        while (!isInterrupted())
            try {
                count++;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
    }
}



