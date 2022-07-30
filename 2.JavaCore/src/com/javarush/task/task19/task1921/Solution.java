package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        //if (args.length == 0) return;

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready()) {

            String line = reader.readLine();

            char[] charArray = line.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (Character.isDigit(charArray[i])) {
                    String name = new String(charArray, 0, i - 1);
                    String dateStr = new String(charArray, i, charArray.length - i);
                    SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
                    try {
                        Date date = formatter.parse(dateStr);
                        PEOPLE.add(new Person(name, date));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
        reader.close();
    }
}
