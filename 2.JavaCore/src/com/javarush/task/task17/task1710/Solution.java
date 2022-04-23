package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static SimpleDateFormat converter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1


    }

    public static void main(String[] args) throws ParseException {


        if (args[0].equals("-c") && args[2].equals("м")) {
            Person person = Person.createMale(args[1], formatter.parse(args[3]));
            allPeople.add(person);
            System.out.println(allPeople.lastIndexOf(person));
        } else if (args[0].equals("-c") && args[2].equals("ж")) {
            Person person = Person.createFemale(args[1], formatter.parse(args[3]));
            allPeople.add(person);
            System.out.println(allPeople.lastIndexOf(person));
        } else if (args[0].equals("-r")) {
            printPerson(allPeople.get(Integer.parseInt(args[1])));
        } else if (args[0].equals("-u")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));

            person.setName(args[2]);
            if (args[3].equals("м")) {
                person.setSex(Sex.MALE);
            } else if (args[3].equals("ж")) {
                person.setSex(Sex.FEMALE);
            }
            person.setBirthDate(formatter.parse(args[4]));
            allPeople.set(Integer.parseInt(args[1]), person);

        } else if (args[0].equals("-d")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
            allPeople.set(Integer.parseInt(args[1]), person);
           //allPeople.remove(Integer.parseInt(args[1]));
        }

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
