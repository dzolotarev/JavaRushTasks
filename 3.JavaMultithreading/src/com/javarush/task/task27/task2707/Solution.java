package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/

import java.util.concurrent.atomic.AtomicBoolean;

public class Solution{
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here
        AtomicBoolean o2Captured = new AtomicBoolean(false);

        Thread thread0 = new Thread(() -> {
            synchronized (o1){
                while (true){

                }
            }
        });

        Thread thread1 = new Thread(() -> solution.someMethodWithSynchronizedBlocks(o1,o2));

        Thread thread2 = new Thread(() -> {
            synchronized (o2){
                o2Captured.set(true);
                synchronized (o1){}
            }

        });

        thread0.start();
        Thread.sleep(100);
        thread1.start();
        Thread.sleep(100);
        thread2.start();
        Thread.sleep(100);
        thread0.stop();

        return o2Captured.get();
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}


//    private static volatile boolean flag = false;
//    private static volatile boolean isInnerThreadBlocked = false;
//
//    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
//        //do something here
//        synchronized (o1) {
//            Thread outerThread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    Thread innerThread = new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            solution.someMethodWithSynchronizedBlocks(o1, o2);
//                        }
//                    });
//                    innerThread.start();
//
//                    while (innerThread.getState() != Thread.State.BLOCKED) ;
//                    isInnerThreadBlocked = true;
//                    synchronized (o2) {
//                        flag = true;
//                    }
//                }
//            });
//            outerThread.setDaemon(true);
//            outerThread.start();
//
//            while (!isInnerThreadBlocked) {
//                Thread.sleep(1);
//            }
//            while (outerThread.getState() != Thread.State.BLOCKED && outerThread.isAlive()) {
//                Thread.sleep(1);
//            }
//        }
//        return flag;
//    }