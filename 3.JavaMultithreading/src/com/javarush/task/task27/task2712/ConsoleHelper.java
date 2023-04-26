package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ConsoleHelper {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return bufferedReader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();
        writeMessage("Выберите блюдо (введите его название): "+Dish.allDishesToString());
        String input = null;
        while (!(input = readString().trim()).equalsIgnoreCase("exit")) {
            Dish dish = null;
            try {
                dish = Dish.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e) {
                writeMessage("Такого блюда нет. Попробуйте еще раз.");
                continue;
            }

            if (dish != null) {
                dishes.add(dish);
                writeMessage("Блюдо " + input.toUpperCase() + " добавлено.");
            }
        }
        return dishes;
    }
//    public static List<Dish> getAllDishesForOrder() throws IOException {
//        List<Dish> dishes = new ArrayList<>();
//        ConsoleHelper.writeMessage("Please choose a dish from the list:" + Dish.allDishesToString() + "\n or type 'exit' to complete the order");
//        while (true) {
//            String dishName = ConsoleHelper.readString().trim();
//            if ("exit".equals(dishName)) {
//                break;
//            }
//
//            try {
//                Dish dish = Dish.valueOf(dishName);
//                dishes.add(dish);
//                writeMessage(dishName + " has been successfully added to your order");
//            } catch (Exception e) {
//                writeMessage(dishName + " hasn't been detected");
//            }
//        }
//
//        return dishes;
//    }
    
}
