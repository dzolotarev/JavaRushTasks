package com.javarush.task.task20.task2013;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/* 
Externalizable Person
*/

public class Solution {
    public static class Person implements Externalizable{
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(){
        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            mother = (Person) in.readObject();
            father = (Person) in.readObject();
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            age = in.readInt();
            children = (List) in.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
         Person man = new Person("Ivan", "Ivanov", 40);
        man.setFather(man);
        man.setMother(man);
        man.setChildren(Arrays.asList(man, man, man));

//        Person child1 = new Person("Son", "Sons", 13);
//        Person child2 = new Person("Daughter", "Daughter", 7);
//        child1.setFather(man);
//        child2.setFather(man);
// ----------
//        FileOutputStream fileOutputStream = new FileOutputStream("/Users/denis/Downloads/test6.txt");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        objectOutputStream.writeObject(man);
//        objectOutputStream.close();
// ----------
        FileInputStream fileInputStream = new FileInputStream("/Users/denis/Downloads/test6.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Person someNewPerson1 = (Person) objectInputStream.readObject();
        System.out.println(someNewPerson1);
        objectInputStream.close();

    }
}
