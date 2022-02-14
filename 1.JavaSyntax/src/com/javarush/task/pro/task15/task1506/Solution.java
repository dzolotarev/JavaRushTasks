package com.javarush.task.pro.task15.task1506;

import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<String> lines = Files.readAllLines(Path.of(scanner.nextLine()));
            for (String s : lines) {
                    s = s.replaceAll("[\\\\.,\\s]", "");
                System.out.println(s);
                //другое решение
//                lines.forEach(str -> {
//                    char[] chars = str.toCharArray();
//                    for (char character : chars) {
//                        if (character != ' ' && character != '.' && character != ',') {
//                            System.out.print(character);
                //конец
            }

        } catch (Exception e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}

