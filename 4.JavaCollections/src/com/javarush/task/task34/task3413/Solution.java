package com.javarush.task.task34.task3413;

/* 
Кеш на основании SoftReference
*/

public class Solution {
    public static void main(String[] args) {
        SoftCache cache = new SoftCache();

        for (long i = 0; i < 2_500_000; i++) {
            cache.put(i, new AnyObject(i, null, null));
        }
        System.out.println(cache.get(350_000L));
        System.out.println(cache.get(130_000L));
        System.out.println(cache.get(35_000L));
        System.out.println(cache.get(10_000L));
        System.out.println(cache.remove(350_000L));
        System.out.println(cache.get(350_000L));

        System.out.println(cache.put(2_500_001L,new AnyObject(2_500_001L, null, null)));
        System.out.println(cache.get(2_500_001L));

    }
}