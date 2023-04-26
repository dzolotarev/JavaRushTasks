package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Map;

public class DirectorTablet {

    //Используя метод getVideoEvents() вывести в консоль в убывающем порядке даты и суммы.
//Для каждой даты из хранилища событий, для которой есть показанная реклама, должна выводится сумма прибыли за показы рекламы для этой даты.
//В конце вывести слово Total и общую сумму.
    public void printAdvertisementProfit() {
        StatisticManager statisticManager = StatisticManager.getInstance();
        Map<String, Double> videoEvents = statisticManager.getVideoEvents();
        Double total = 0.0;
        for (Map.Entry<String, Double> videoEvent : videoEvents.entrySet()) {
            String stringDate = videoEvent.getKey();

            Double amount = videoEvent.getValue();
            total += amount;
            String result = String.format("%s - %.2f", stringDate, amount);
            ConsoleHelper.writeMessage(result);
        }
        String totalString = String.format("Total - %.2f%n", total);
        ConsoleHelper.writeMessage(totalString);
    }


    public void printCookWorkloading() {
        StatisticManager statisticManager = StatisticManager.getInstance();
        Map<String, Map<String, Integer>> cookEvents = statisticManager.getCookEvents();
        for (Map.Entry<String, Map<String, Integer>> stringMapEntry : cookEvents.entrySet()) {
            String stringDate = stringMapEntry.getKey();
            ConsoleHelper.writeMessage(stringDate);
            Map<String, Integer> value = stringMapEntry.getValue();
            for (Map.Entry<String, Integer> stringIntegerEntry : value.entrySet()) {
                String name = stringIntegerEntry.getKey();
                Integer time = stringIntegerEntry.getValue();
                if (time > 0) {
                    String result = String.format("%s - %d min", name, (int) Math.ceil((double) time / 60));
                    ConsoleHelper.writeMessage(result);
                }
            }
            ConsoleHelper.writeMessage("");
        }

    }

    public void printActiveVideoSet() {
        Map<String, Integer> videoSet = StatisticAdvertisementManager.getInstance().getVideoSet();
        for (Map.Entry<String, Integer> stringIntegerEntry : videoSet.entrySet()) {
            String name = stringIntegerEntry.getKey();
            Integer hits = stringIntegerEntry.getValue();
            if (hits > 0) {
                String result = String.format("%s - %d", name, hits);
                ConsoleHelper.writeMessage(result);
            }
        }
        ConsoleHelper.writeMessage("");
    }

    public void printArchivedVideoSet() {
        Map<String, Integer> videoSet = StatisticAdvertisementManager.getInstance().getVideoSet();
        for (Map.Entry<String, Integer> stringIntegerEntry : videoSet.entrySet()) {
            String name = stringIntegerEntry.getKey();
            Integer hits = stringIntegerEntry.getValue();
            if (hits == 0) {
                String result = String.format("%s", name);
                ConsoleHelper.writeMessage(result);
            }
        }
        ConsoleHelper.writeMessage("");
    }
}
