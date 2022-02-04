package com.javarush.task.pro.task10.task1021;

/* 
Автопроизводитель
*/

public class Car {
    private String model;
    private int year;
    private String color;

    public void initialize(String model, int year, String color) {
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.initialize("Ferrari", 1981, "Red");
        Car car1 = new Car();
        car1.initialize("Lambogini", 1999, "Yelow");
        System.out.println(car.color + " " + car.model + " " + car.year);
        System.out.println(car1.color + " " + car1.model + " " + car1.year);

    }
}
