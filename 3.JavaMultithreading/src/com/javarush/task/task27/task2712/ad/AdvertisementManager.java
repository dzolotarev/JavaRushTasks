package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//у каждого планшета будет свой объект менеджера, который будет подбирать
// оптимальный набор роликов и их последовательность для каждого заказа.
public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;


    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        }

        List<Advertisement> ads = getVideoAdsWithHits(storage.list());

        List<Advertisement> advertList = getVideoList(ads, timeSeconds);
        videoSort(advertList);

        if (!advertList.isEmpty()) {
            long amount = 0;
            int totalDuration = 0;
            for (Advertisement advertisement : advertList) {
                amount += advertisement.getAmountPerOneDisplaying();
                totalDuration += advertisement.getDuration();
            }

            StatisticManager.getInstance().register(new VideoSelectedEventDataRow(advertList, amount, totalDuration));
        }

        for (Advertisement ad : advertList) {
            String result = String.format("%s is displaying... %d, %d", ad.getName(), ad.getAmountPerOneDisplaying(), (int) (ad.getAmountPerOneDisplaying() * 1000 / ad.getDuration()));
            ConsoleHelper.writeMessage(result);
        }

        for (Advertisement advertisement : storage.list()) {
            if (advertList.contains(advertisement)) {
                advertisement.revalidate();
            }
        }


    }

    private List<Advertisement> getVideoList(List<Advertisement> adverts, int timeSeconds) {
        long[][] T = new long[adverts.size() + 1][timeSeconds + 1];
        for (int i = 1; i <= adverts.size(); i++) {
            for (int j = 0; j <= timeSeconds; j++) {
                if (adverts.get(i - 1).getDuration() > j) {
                    T[i][j] = T[i - 1][j];
                } else {
                    T[i][j] = Long.max(T[i - 1][j], T[i - 1][j - adverts.get(i - 1).getDuration()] + adverts.get(i - 1).getAmountPerOneDisplaying());
                }
            }
        }
        //long h = T[adverts.size()][timeSeconds]; ///VALUE

        List<Advertisement> tmpList = new ArrayList<>(); // массив, куда будем собирать видосики
        for (int i = adverts.size(); i > 0; i--) {
            if (T[i][timeSeconds] != T[i - 1][timeSeconds]) {
                tmpList.add(adverts.get(i - 1));
                timeSeconds -= adverts.get(i - 1).getDuration();
            }
        }
        return tmpList;
    }


//    private long getVideoList(List<Advertisement> adverts, int n, int timeSeconds) {
//        if (timeSeconds < 0) { //если больше видео не помещается возвращем -inf
//            return Long.MIN_VALUE;
//        }
//
//        if (n < 0 || timeSeconds == 0) { //обработали весь список или //если новое видео не влезет
//            return 0;
//        }
//
//        int w = adverts.get(n).getDuration();
//        long v = adverts.get(n).getAmountPerOneDisplaying();
//
//        long include = v + getVideoList(adverts, n - 1, timeSeconds - w);
//        long exclude = getVideoList(adverts, n - 1, timeSeconds);
//        long value;
//
//        if (include > exclude) {
//            value = include;
//            readySet.add(adverts.get(n));
//        } else {
//            value = exclude;
//        }
//        return value;
//    }

    private List<Advertisement> getVideoAdsWithHits(List<Advertisement> list) {
        List<Advertisement> tmplist = new ArrayList<>();
        if (list.size() == 0) {
            return tmplist;
        }
        for (Advertisement ad : list) {
            if (ad.getHits() > 0) {
                tmplist.add(ad);
            }
        }
        return tmplist;
    }

    private void videoSort(List<Advertisement> readyList) {
        if (readyList.size() > 0) {
            Collections.sort(readyList, new Comparator<Advertisement>() {
                @Override
                public int compare(Advertisement o1, Advertisement o2) {
                    if (o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying() == 0) {
                        return o2.getDuration() - o1.getDuration();
                    }
                    return (int) o2.getAmountPerOneDisplaying() - (int) o1.getAmountPerOneDisplaying();
                }
            });
        }
    }

}
