package com.javarush.task.pro.task15.task1516;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Файл или директория
*/

public class Solution {
    private static final String THIS_IS_FILE = " - это файл";
    private static final String THIS_IS_DIR = " - это директория";

    public static void main(String[] args) {
        InputStream stream = System.in;
        Scanner scanner = new Scanner(stream);
        while (true) {
            String str = scanner.nextLine();
            Path path = Path.of(str);
            if (Files.isRegularFile(path))
                System.out.println(str + THIS_IS_FILE);
            else if (Files.isDirectory(path))
                System.out.println(str + THIS_IS_DIR);
            else {
                break;
            }

        }
    }
}

