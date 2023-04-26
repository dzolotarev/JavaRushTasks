package com.javarush.task.task27.task2712.statistic;

//Менеджер статистики. С его помощью будем регистрировать события в хранилище.

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static final StatisticManager instance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        return instance;
    }

    public void register(EventDataRow data) {
        this.statisticStorage.put(data);
    }

    //создай метод (придумать самостоятельно), который из хранилища достанет все данные, относящиеся
    //к отображению рекламы, и посчитает общую прибыль за каждый день.
    public Map<String, Double> getVideoEvents() {
        Map<String, Double> videoEvents = new TreeMap<>(Collections.reverseOrder());
        List<EventDataRow> eventDataRowList = this.statisticStorage.get().get(EventType.SELECTED_VIDEOS);

        for (EventDataRow eventDataRow : eventDataRowList) {
            VideoSelectedEventDataRow videoSelectedEventDataRow = (VideoSelectedEventDataRow) eventDataRow;
            Date date = videoSelectedEventDataRow.getDate();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH);
            String stringDate = simpleDateFormat.format(date);
            Double amount = (double) videoSelectedEventDataRow.getAmount() / 100;
            videoEvents.put(stringDate, videoEvents.getOrDefault(stringDate, 0.0) + amount);
        }
        return videoEvents;
    }

    public Map<String, Map<String, Integer>> getCookEvents() {
        Map<String, Map<String, Integer>> cookEvents = new TreeMap<>(Collections.reverseOrder());

        List<EventDataRow> eventDataRowList = this.statisticStorage.get().get(EventType.COOKED_ORDER);
        for (EventDataRow eventDataRow : eventDataRowList) {
            CookedOrderEventDataRow cookedOrderEventDataRow = (CookedOrderEventDataRow) eventDataRow;

            Date date = cookedOrderEventDataRow.getDate();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH);
            String stringDate = simpleDateFormat.format(date);

            Map<String, Integer> cookTimes = new TreeMap<>();
            for (EventDataRow eventDataRow1 : eventDataRowList) {
                CookedOrderEventDataRow cookedOrderEventDataRow1 = (CookedOrderEventDataRow) eventDataRow1;
                String cookName = cookedOrderEventDataRow1.getCookName();
                int cookTime = cookedOrderEventDataRow1.getTime(); //time in seconds
                cookTimes.put(cookName, cookTimes.getOrDefault(cookName, 0) + cookTime);
            }
            cookEvents.put(stringDate, cookTimes);
        }
        return cookEvents;
    }

    private static class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            for (EventType eventType : EventType.values()) {
                this.storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        //Дополнительно добавь вспомогательный метод get в класс хранилища, чтобы получить доступ к данным.
        private Map<EventType, List<EventDataRow>> get() {
            return storage;
        }

        private void put(EventDataRow data) {
            if (!this.storage.containsKey(data.getType())) {
                throw new UnsupportedOperationException();
            }
            List<EventDataRow> list = storage.get(data.getType());
            list.add(data);
            this.storage.put(data.getType(), list);
            //this.storage.get(data.getType()).add(data); //simple and short method
        }
    }
}
