package com.javarush.task.pro.task11.task1106;

public class Main {
    public static void main(String[] args) {
        Car.beepAction();
        Car car = new Car();
        car.beepAction1();

        car.setModelName("Ferrari");

        car.beepAction1();
    }
}
