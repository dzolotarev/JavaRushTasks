package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();

    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            if (Country.UKRAINE.equals(country)) {
                hen = new UkrainianHen();
            } else if (Country.BELARUS.equals(country)) {
                hen = new BelarusianHen();
            } else if (Country.MOLDOVA.equals(country)) {
                hen = new MoldovanHen();
            } else if (Country.RUSSIA.equals(country)) {
                hen = new RussianHen();
            }
            return hen;
        }
    }












}
