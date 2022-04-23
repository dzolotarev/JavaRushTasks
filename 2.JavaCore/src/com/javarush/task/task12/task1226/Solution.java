package com.javarush.task.task12.task1226;

/* 
Лазать, летать и бегать
*/

public class Solution {

    public static void main(String[] args) {

    }

    public interface CanRun {
        void run();
    }

    public interface CanClimb {
        void climb();
    }

    public interface CanFly {
        void fly();
    }

    public class Cat implements CanRun, CanClimb {
        @Override
        public void run() {

        }

        @Override
        public void climb() {

        }
    }

    public class Dog implements CanRun {
        @Override
        public void run() {

        }
    }

    public class Tiger extends Cat {
    }

    public class Duck implements CanFly, CanRun {
        @Override
        public void run() {

        }

        @Override
        public void fly() {

        }
    }
}
