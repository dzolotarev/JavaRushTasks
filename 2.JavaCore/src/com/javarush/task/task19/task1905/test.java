package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

public class test {

    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    public static void main(String[] args) {
//
//        String countryCode = "";
//
//        for (Map.Entry<String, String> c : countries.entrySet()) {
//            if (c.getValue().equals("Ukraine")) countryCode = c.getKey();
//        }
//
//        System.out.println(countryCode);
//        String input = "+380(50)123-4567";
//        String number = input.replaceAll("\\D+", "");
//        String fin_ = String.format("callto://+%s", number);
//
//        System.out.println(number);
//        System.out.println(fin_);


        String fullName = "Ivanov, Ivan";
        String  secondName = fullName.substring(fullName.lastIndexOf(",")+2);
        String firstName = fullName.substring(0,fullName.indexOf(","));
        System.out.println(fullName);
        System.out.println(firstName);
        System.out.println(secondName);






    }
}
