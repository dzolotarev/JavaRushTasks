package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.StringJoiner;
import java.util.logging.Logger;

/* 
Сериализация человека
*/

public class Solution {

    public static class Person implements Serializable{
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greeting;
        String country;
        Sex sex;
        transient PrintStream  outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greeting = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex implements Serializable{
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person man = new Person("Ivan", "Ivanov", "RU", Sex.MALE);

        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);
        StringBuilder sb = new StringBuilder();
        StringJoiner sj = new StringJoiner(" ");

        sj = sj.add(man.country).add(man.firstName).add(man.lastName).add(man.fullName).add(man.sex.toString()).add(man.greeting).add(man.outputStream.toString()).add(man.logger.toString());
        System.out.println(sj);


        oos.writeObject(man);

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);
        Person man1 = (Person) ois.readObject();
        System.out.println(man1.country);
        System.out.println(man1.firstName);
        System.out.println(man1.lastName);
        System.out.println(man1.fullName);
        System.out.println(man1.sex);
        System.out.println(man1.greeting);
        System.out.println(man1.outputStream);
        System.out.println(man1.logger);

    }
}
