package com.javarush.task.task36.task3602;

/*
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class result = null;
        Class[] aClasses = Collections.class.getDeclaredClasses();

        for (Class aClass : aClasses) {
            if (List.class.isAssignableFrom(aClass) && List.class.isAssignableFrom(aClass.getSuperclass())
                    && Modifier.isPrivate(aClass.getModifiers()) && Modifier.isStatic(aClass.getModifiers())) {
                for (Method method : aClass.getDeclaredMethods()) {
                    if (method.getName().startsWith("get") && method.getParameterTypes().length == 1) {
                        try {
                            Constructor constructor = aClass.getDeclaredConstructor();
                            constructor.setAccessible(true);
                            Object object = constructor.newInstance();
                            method.setAccessible(true);
                            method.invoke(object, 0);
                        } catch (InvocationTargetException e) {
                            if (e.getCause() instanceof IndexOutOfBoundsException) {
                                result = aClass;
                            }
                        } catch (IllegalArgumentException | IllegalAccessException | InstantiationException |
                                 NoSuchMethodException ignored) {
                        }
                    }
                }
            }
        }
        return result;
    }
}