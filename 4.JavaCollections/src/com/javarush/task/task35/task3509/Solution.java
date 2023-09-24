package com.javarush.task.task35.task3509;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* 
Collections & Generics
*/

public class Solution {

    public static void main(String[] args) {
        HashMap<Object, Number> map = newHashMap(newArrayList("first", "second"), newArrayList(1,2));
        System.out.println(map);
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        //напишите тут ваш код
        ArrayList<T> newArrayList = new ArrayList<>();
        for (T element : elements) {
            newArrayList.add(element);
        }
        return newArrayList;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        //напишите тут ваш код
        HashSet<T> newHashSet = new HashSet<>();
        for (T element : elements) {
            newHashSet.add(element);
        }
        return newHashSet;
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        //напишите тут ваш код
        if (keys.size() != values.size()) {
            throw new IllegalArgumentException();
        }
        HashMap<K, V> newHashMap = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            newHashMap.put(keys.get(i), values.get(i));
        }
        return newHashMap;
    }
}
