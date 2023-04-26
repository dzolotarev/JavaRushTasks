package com.javarush.task.task27.task2712.kitchen;


public enum Dish {
    FISH(25),
    STEAK(30),
    SOUP(15),
    JUICE(5),
    WATER(3);

    private final int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString(){
        StringBuilder stringBuilder = new StringBuilder();
        Dish[] dishes = Dish.values();
        for (int i = 0; i < dishes.length-1; i++) {
            stringBuilder.append(dishes[i].toString()).append(", ");
        }
        stringBuilder.append(dishes[dishes.length-1]);
        return stringBuilder.toString();
//          String result = "";
//        for (Dish dish : Dish.values()) {
//            if ("".equals(result)) {
//                result += dish.name();
//            } else {
//                result += ", " + dish.name();
//            }
    }

}
