package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

/* 
Десериализация JSON объекта
*/

public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        File file = new File(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        return (T) objectMapper.readValue(file, clazz); //mapper.readValue(new FileReader(new File(fileName)), clazz)
    }

    public static void main(String[] args) throws IOException {
        String test = "/Users/denis/Downloads/cat.class_json.txt";
        Cat cat = convertFromJsonToNormal(test, Cat.class);
        System.out.println(cat);
    }
}
