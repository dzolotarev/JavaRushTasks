package com.javarush.task.task33.task3304;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Конвертация из одного класса в другой используя JSON Ӏ 3304
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Second s = (Second) convertOneToAnother(new First(), Second.class);
        First f = (First) convertOneToAnother(new Second(), First.class);
        System.out.println(s.getClass());
        System.out.println(f.getClass());
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(MapperFeature.USE_ANNOTATIONS); //отключаем асе аннотации
        StringWriter writer = new StringWriter();
        objectMapper.writeValue(writer, one);
        StringReader reader = new StringReader(writer.toString());
        return objectMapper.readValue(reader, resultClassObject);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = First.class, name = "first"))
    public static class First {
        public int i;
        public String name;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = Second.class, name = "second"))
    public static class Second {
        public int i;
        public String name;
    }

    //альтернативный вариант - без отключения аннотаций - json распарсить и заменить в нем поле-идентификатор класса
    //        String key1 = "\"" + one.getClass().getSimpleName().toLowerCase() + "\"";
    //        String key2 = "\"" + resultClassObject.getSimpleName().toLowerCase() + "\"";
    //        ss = ss.replaceFirst(key1, key2); //String ss - наш json объект
}
