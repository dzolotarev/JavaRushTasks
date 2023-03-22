package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;
import java.util.StringJoiner;

public class Order {
    private final Tablet tablet;

    public Tablet getTablet() {
        return tablet;
    }

    protected List<Dish> dishes;


    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    public int getTotalCookingTime() {
        int totalTime = 0;
        for (Dish dish : dishes) {
            totalTime += dish.getDuration();
        }
        return totalTime;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }

    protected void initDishes() throws IOException {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        String result = "";
        StringJoiner stringJoiner = new StringJoiner(", ");
        if (dishes.isEmpty()) {
            return result;
        }
        for (Dish dish : dishes) {
            stringJoiner.add(dish.toString());
        }
        result = stringJoiner.toString();
        return "You order: [" + result + "] of " + tablet.toString() + ", cooking time " + getTotalCookingTime() + "min";
    }

//public String toString() {
//        String result = "";
//        if (dishes.size() == 0) return result;
//        result += "Your order: [" + dishes.get(0);
//
//        for (int i = 1; i < dishes.size(); i++) {
//            result += ", " + dishes.get(i).name();
//        }
//        result += "] of " + tablet;
//        return result;
//    }    
}
