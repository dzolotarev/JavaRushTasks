package com.javarush.task.task27.task2712.ad;

import java.util.Map;
import java.util.TreeMap;

public class StatisticAdvertisementManager {
    //будет предоставлять информацию из AdvertisementStorage в нужном нам виде
    private static final StatisticAdvertisementManager instance = new StatisticAdvertisementManager();
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager() {
    }

    public static StatisticAdvertisementManager getInstance() {
        return instance;
    }

    public Map<String, Integer> getVideoSet() {
        Map<String, Integer> videoSet = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for (Advertisement advertisement : storage.list()) {
            String name = advertisement.getName();
            Integer hits = advertisement.getHits();
            videoSet.put(name, hits);
        }
        return videoSet;
    }
}
