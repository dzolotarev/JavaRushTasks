package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

/**
 * @author Denis Zolotarev
 */
public class Consumer implements Runnable {
    private final TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(450);
            while (!Thread.currentThread().isInterrupted()) {
                System.out.format("Processing %s%n", queue.take());
            }
        } catch (InterruptedException ignored) {
        }
    }
}
