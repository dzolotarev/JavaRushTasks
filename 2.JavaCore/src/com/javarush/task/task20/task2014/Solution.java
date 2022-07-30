package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution1 = new Solution(4);
        Solution solution2 = new Solution(44);
        System.out.println(solution1.string);
        System.out.println(solution2.string);
        System.out.println(solution1.string.equals(solution2.string));

        FileOutputStream outputStream = new FileOutputStream("/Users/denis/Downloads/test6.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(solution1);
        objectOutputStream.close();

        FileInputStream inputStream = new FileInputStream("/Users/denis/Downloads/test6.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        solution2 = (Solution) objectInputStream.readObject();
        System.out.println(solution2);
        System.out.println(solution1.string.equals(solution2.string));



    }


    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
