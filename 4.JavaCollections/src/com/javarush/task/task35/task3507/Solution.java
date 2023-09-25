package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/

public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws ClassNotFoundException, IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        List<File> listOfClasses = getOnlyClassFiles(pathToAnimals);

        Set<Animal> resultSet = new HashSet<>();

        CustomClassLoader classLoader = new CustomClassLoader();
        for (File file : listOfClasses) {
            Class<?> aClass = classLoader.findClass(file.getCanonicalPath());
            if (Animal.class.isAssignableFrom(aClass)) {
                Constructor<?>[] constructors = aClass.getConstructors();
                for (Constructor<?> constructor : constructors) {
                    if (constructor.getModifiers() == Modifier.PUBLIC && constructor.getParameterCount() == 0) {
                        Animal animal = (Animal) aClass.getDeclaredConstructor().newInstance();
                        resultSet.add(animal);
                    }
                }
            }
        }

        return resultSet;
    }

    private static List<File> getOnlyClassFiles(String pathToAnimals) {
        File[] files = new File(pathToAnimals).listFiles();
        List<File> classFilesList = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                if (file.getName().endsWith(".class")) {
                    classFilesList.add(file);
                }
            }
        }
        return classFilesList;
    }
}
