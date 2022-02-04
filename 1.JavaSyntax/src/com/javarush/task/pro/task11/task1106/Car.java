package com.javarush.task.pro.task11.task1106;

/* 
Одинаковые машины
*/

public class Car {
    private String modelName;
    private int speed;

    public static void beepAction(){
        System.out.println("B-e-e-e-e-p");
    }

    public void beepAction1(){
        System.out.println("B-e-e-e-e-p once!" + this.getModelName());
    }

    public String getModelName() {
        return this.modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
