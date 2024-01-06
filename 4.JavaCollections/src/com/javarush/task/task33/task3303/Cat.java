package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Denis Zolotarev
 */
@JsonAutoDetect
public class Cat {
    @JsonProperty("wildAnimal")
    public String name;
    @JsonIgnore
    public int age;
    @JsonProperty("over")
    public int weight;

    Cat() {
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}