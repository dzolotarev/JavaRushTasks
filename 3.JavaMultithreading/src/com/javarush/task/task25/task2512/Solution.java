package com.javarush.task.task25.task2512;


import java.util.LinkedList;
import java.util.List;

/* 
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler, Runnable{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        if (e.getCause() != null)
        {
            uncaughtException(t, e.getCause());
        }
        System.out.println(e);
        ///another way
        List<String> res = new LinkedList<>();
        while (e != null) {
            res.add(0, e.toString());
            e = e.getCause();
        }

        for (String s : res) {
            System.out.println(s);
        }


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Thread thread = new Thread (solution);
        thread.setUncaughtExceptionHandler(solution);
        thread.start();


    }

    @Override
    public void run() {
        Exception r = new RuntimeException("Some message");
        throw new RuntimeException("Some other message", r);
       // throw new NullPointerException(";throw new NullPointerException()", );
    }
}
