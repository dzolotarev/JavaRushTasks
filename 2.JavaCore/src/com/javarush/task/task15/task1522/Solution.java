package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static {

        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key = reader.readLine();
        if (Planet.EARTH.equals(key)) {
            thePlanet = Earth.getInstance();
        } else if (Planet.MOON.equals(key)) {
            thePlanet = Moon.getInstance();
        } else if (Planet.SUN.equals(key)) {
            thePlanet = Sun.getInstance();
        } else {
            thePlanet = null;
        }
    }
}
