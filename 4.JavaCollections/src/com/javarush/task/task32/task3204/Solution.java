package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        int numberOfRandomNum = ThreadLocalRandom.current().nextInt(1, 4);
        int numberOfRandomUpperCaseLetter = ThreadLocalRandom.current().nextInt(1, 4);
        int numberOfRandomLowerCaseLetter = 8 - numberOfRandomNum - numberOfRandomUpperCaseLetter;

        List<Character> listOfChar = new ArrayList<>();

        for (int i = 0; i < numberOfRandomNum; i++) {
            //numbers range 48, 57
            listOfChar.add((char) ThreadLocalRandom.current().nextInt(48, 57 + 1));
        }
        for (int i = 0; i < numberOfRandomUpperCaseLetter; i++) {
            listOfChar.add((char) ThreadLocalRandom.current().nextInt('A', 'Z' + 1));
        }
        for (int i = 0; i < numberOfRandomLowerCaseLetter; i++) {
            listOfChar.add((char) ThreadLocalRandom.current().nextInt('a', 'z' + 1));
        }
        for (int i = 0; i < numberOfRandomLowerCaseLetter; i++) {
            Collections.shuffle(listOfChar);
        }

        for (Character character : listOfChar) {
            outputStream.write(character);
        }
        return outputStream;
    }
}
