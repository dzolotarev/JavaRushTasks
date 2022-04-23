package com.javarush.task.task12.task1217;

/* 
Лететь, бежать и плыть
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly {
        void fligtOut(int speed);

    }

    public interface CanRun {
        int run();

    }

    public interface CanSwim {
        double swim(double water);
    }

}
