package com.javarush.task.task21.task2113;


public class Horse {

    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return this.name;
    }

    public double getSpeed() {
        return this.speed;
    }

    public double getDistance() {
        return this.distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void move() {
        distance += speed * Math.random();
    }

    public void print() {
        StringBuilder track = new StringBuilder();
        for (int i = 0; i < (int) distance; i++) {
            track.append(".");
        }
        System.out.println(track + name);
    }
//    public void print() {
//        for (int i = 0; i < Math.floor(distance); i++) {
//            System.out.print(".");
//        }
//        System.out.println(name);
//    }
}
