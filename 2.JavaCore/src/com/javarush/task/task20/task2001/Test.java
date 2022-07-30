package com.javarush.task.task20.task2001;

import com.javarush.task.task12.task1228.Solution;

import java.io.*;

public class Test {
    public static void main(String[] args) throws Exception {
        Cat cat = new Cat();
        Dog dog = new Dog();
        cat.name = "Васька";
        cat.age = 2;
        cat.weight = 3;
        dog.age = 3;
        dog.name = "Бобик";

        Human man = new Human();
        man.cat = cat;
        man.dog = dog;

        FileOutputStream fileOutput = new FileOutputStream("/Users/denis/Downloads/test6.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        man.save(outputStream);
//
//        PrintWriter writer = new PrintWriter("/Users/denis/Downloads/test6.txt");
//        man.save(writer);
//        BufferedReader reader = new BufferedReader(new FileReader("/Users/denis/Downloads/test6.txt"));

//        man.load(reader);
//        System.out.println(man.cat.name);
//        System.out.println(man.cat.age);
//        System.out.println(man.cat.weight);
//        System.out.println(man.dog.name);
//        System.out.println(man.dog.age);





    }
}

class Cat implements Serializable {
    public String name;
    public int age;
    public int weight;

    public void save(PrintWriter writer) throws Exception {
        writer.println(name);
        writer.println(age);
        writer.println(weight);
        writer.flush();
    }

    public void load(BufferedReader reader) throws Exception {
        name = reader.readLine();
        age = Integer.parseInt(reader.readLine());
        weight = Integer.parseInt(reader.readLine());
    }
}

class Dog implements Serializable{
    public String name;
    public int age;

    public void save(PrintWriter writer) throws Exception {
        writer.println(name);
        writer.println(age);
        writer.flush();
    }

    public void load(BufferedReader reader) throws Exception {
        name = reader.readLine();
        age = Integer.parseInt(reader.readLine());
    }
}

class Human {
    public Cat cat;
    public Dog dog;

    public void save(ObjectOutputStream outputStream) throws IOException {
        outputStream.writeObject(cat);
        outputStream.writeObject(dog);
        outputStream.close();
    }

    public void save(PrintWriter writer) throws Exception {
        String isCatPresent = cat != null ? "yes" : "no";
        writer.println(isCatPresent);
        writer.flush();

        if (cat != null)
            cat.save(writer);

        String isDogPresent = dog != null ? "yes" : "no";
        writer.println(isDogPresent);
        writer.flush();

        if (dog != null)
            dog.save(writer);
    }

    public void load(BufferedReader reader) throws Exception {

        String isCatPresent = reader.readLine();
        if (isCatPresent.equals("yes")) {
            cat = new Cat();
            cat.load(reader);
        }

        String isDogPresent = reader.readLine();
        if (isDogPresent.equals("yes")) {
            dog = new Dog();
            dog.load(reader);
        }
    }
}
