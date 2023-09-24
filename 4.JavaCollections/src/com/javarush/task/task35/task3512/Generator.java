package com.javarush.task.task35.task3512;

import java.lang.reflect.InvocationTargetException;

public class Generator<T> {
    private Class<T> clazz;

    public Generator(Class<T> clazz) {
        this.clazz = clazz;
    }

    T newInstance() {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
