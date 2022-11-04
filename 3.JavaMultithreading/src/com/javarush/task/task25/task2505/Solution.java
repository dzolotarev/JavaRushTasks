package com.javarush.task.task25.task2505;

/* 
Без дураков
*/

public class Solution {

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            //setDaemon(true);
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }

        private class MyUncaughtExceptionHandler extends Thread implements UncaughtExceptionHandler {

            public MyUncaughtExceptionHandler() {
            }

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                String str = null;

                if(t instanceof MyThread) {
                    MyThread o = (MyThread) t;
                    str = o.secretKey; // easiest way: MyThread.this.secretKey
                }

                String string = String.format("%s, %s, %s", str, t.getName(), e.getMessage());

                System.out.println(string);

                //super secret key, Thread-0, it's an example
            }
        }
    }

}

