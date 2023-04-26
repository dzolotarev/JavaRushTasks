package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.util.Date;
import java.util.List;


public class CookedOrderEventDataRow implements EventDataRow {
    String tabletName;
    String cookName;
    int cookingTimeSeconds;
    List<Dish> cookingDishes;
    Date currentDate;

    public CookedOrderEventDataRow(String tabletName, String cookName, int cookingTimeSeconds, List<Dish> cookingDishes) {
        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.cookingDishes = cookingDishes;
        this.currentDate = new Date();
        //где - tabletName - имя планшета
        //cookName - имя повара
        //cookingTimeSeconds - время приготовления заказа в секундах
        //cookingDishes - список блюд для приготовления
    }

    public String getCookName() {
        return cookName;
    }

    public List<Dish> getCookingDishes() {
        return cookingDishes;
    }

    @Override
    public EventType getType() {
        return EventType.COOKED_ORDER;
    }

    @Override
    public Date getDate() {
        return currentDate;
    }

    @Override
    public int getTime() {
        return cookingTimeSeconds;
    }
}
