package com.javarush.task.task12.task1216;

/* 
Летать охота
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly {
        void flyIn(int speed, int height, int outsideTemp);

        void flyOut(int speed, int height, int outsideTemp);
    }

}
