package com.javarush.task.task25.task2511;

import javax.swing.plaf.TableHeaderUI;
import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/

public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;

        class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                String threadName = t.getName();
                String regexp = threadName.replaceAll(".","*");
                String result = e.getMessage().replaceAll(threadName,regexp);
                System.out.println(result);

            }
        }

        this.handler = new UncaughtExceptionHandler();    //init handler here

    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
// Test data
        Solution solution = new Solution(new TimerTask() {
            @Override
            public void run() {
                throw new RuntimeException();
            }
        });
        Thread thread = new Thread(solution);

        solution.run();
        thread.start();

    }
}
