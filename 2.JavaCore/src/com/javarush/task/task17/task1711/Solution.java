package com.javarush.task.task17.task1711;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static SimpleDateFormat converter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        if (args.length == 0) {
            System.out.println("Enter arguments first...");
        }
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    addPeople(args);
                    break;
                }
            case "-u":
                synchronized (allPeople) {
                    updatePeople(args);
                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    deletePeople(args);
                    break;
                }
            case "-i":
                synchronized (allPeople) {
                    showPeople(args);
                    break;
                }
        }
    }

    public static void addPeople(String[] args) throws ParseException {
        for (int i = 1; i < args.length; i += 3) {
//            System.out.println(isMale(args[i + 1]));
//            System.out.println(args[i]);
//            System.out.println(args[i + 1]);
//            System.out.println(args[i + 2]);
            System.out.println((isMale(args[i + 1])) ? newMale(args[i], args[i + 2]) : newFemale(args[i], args[i + 2]));
        }
    }

    public static void updatePeople(String[] args) throws ParseException {

        for (int i = 1; i < args.length; i += 4) {
            Person person = ((isMale(args[i + 2])) ? Person.createMale(args[i + 1], formatter.parse(args[i + 3])) : Person.createFemale(args[i + 1], formatter.parse(args[i + 3])));
            allPeople.set(Integer.parseInt(args[i]), person);
        }
    }

    public static void deletePeople(String[] args) {
        for (int i = 1; i < args.length; i++) {
            Person person = allPeople.get(Integer.parseInt(args[i]));
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
            allPeople.set(Integer.parseInt(args[i]), person);
        }
    }

    public static void showPeople(String[] args) {
        for (int i = 1; i < args.length; i++) {
            Person person = allPeople.get(Integer.parseInt(args[i]));
            printPerson(person);
        }
    }

    public static boolean isMale(String s) {
        if (s == null) return false;
        return s.equals("м");
    }

    public static int newMale(String name, String birth) throws ParseException {
        Person person = Person.createMale(name, formatter.parse(birth));
        allPeople.add(person);
        return allPeople.lastIndexOf(person);
    }

    public static int newFemale(String name, String birth) throws ParseException {
        Person person = Person.createFemale(name, formatter.parse(birth));
        allPeople.add(person);
        return allPeople.lastIndexOf(person);
    }

    public static void printPerson(Person person) {
        String sex = "";
        if (person.getSex().equals(Sex.MALE)) {
            sex = "м";
        } else if (person.getSex().equals(Sex.FEMALE)) {
            sex = "ж";
        }
        System.out.println(person.getName() + " " + sex + " " + converter.format(person.getBirthDate()));
    }
}
