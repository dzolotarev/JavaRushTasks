package com.javarush.task.task25.task2502;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Машину на СТО не повезем!
*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            if (loadWheelNamesFromDB().length != 4) {
                throw new IllegalArgumentException();
            }
            Set<Wheel> set = new HashSet<>();
            ;

            for (String name : loadWheelNamesFromDB()) {

                Wheel wheel = Wheel.valueOf(name);
                set.add(wheel);
            }
            if (set.size() != 4) {
                throw new IllegalArgumentException();
            }
            wheels = new ArrayList<>(set);
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
    }
}
