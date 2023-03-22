package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

//хранилище рекламных роликов
public class AdvertisementStorage {

    private static final AdvertisementStorage instance = new AdvertisementStorage();
    private final List<Advertisement> videos = new ArrayList<>();



    public static AdvertisementStorage getInstance() {
        return instance;
    }

    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }

    private AdvertisementStorage() {
        Object someContent = new Object();
        videos.add(new Advertisement(someContent, "А_Видео 1", 1523, 3, 3 * 60));
        videos.add(new Advertisement(someContent, "Video 2", 5, 2, 60));
        videos.add(new Advertisement(someContent, "Video 3", 99, 2, 3 * 60));
        videos.add(new Advertisement(someContent, "Video 4", 99, 10, 2 * 60));
        videos.add(new Advertisement(someContent, "В_Видео 5", 2506, 3, 3 * 60));
        videos.add(new Advertisement(someContent, "Б_Видео 2", 2506, 3, 3 * 60));
        videos.add(new Advertisement(someContent, "Video 7", 400, 1, 3 * 60));
        videos.add(new Advertisement(someContent, "Video 8", 500, 1, 2 * 60));
        videos.add(new Advertisement(someContent, "Video 10", 400, 2, 3 * 60));
        videos.add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
        videos.add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
        videos.add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60)); //10 min
    }
}
