package com.javarush.task.task28.task2805;

public class MyThread extends Thread {
    private static int priority = Thread.MIN_PRIORITY;
    //private AtomicInteger priority = new AtomicInteger(Thread.MIN_PRIORITY);

    {
        if (priority <= Thread.MAX_PRIORITY) {
            this.setPriority(priority);
            priority++;
        } else {
            this.setPriority(Thread.MIN_PRIORITY);
            priority = 2;
        }
    }

    public MyThread() {
        super();

    }

    public MyThread(Runnable target) {
        super(target);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
//        if (priority <= group.getMaxPriority()) {
//            super.setPriority(priority++);
//        } else if (priority > group.getMaxPriority() && priority <= Thread.MAX_PRIORITY) {
//            super.setPriority(group.getMaxPriority());
//            priority++;
//        } else if (priority > Thread.MAX_PRIORITY) {
//            super.setPriority(Thread.MIN_PRIORITY);
//            priority = 2;
//        }
    }

    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }

}
