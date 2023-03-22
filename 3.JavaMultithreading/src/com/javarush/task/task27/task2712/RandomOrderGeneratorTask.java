package com.javarush.task.task27.task2712;

import java.util.List;
import java.util.Random;

/**
 * @author Denis Zolotarev
 */
class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tablets;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        while (true) {
            int index = new Random().nextInt(tablets.size());
            tablets.get(index).createTestOrder();
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
