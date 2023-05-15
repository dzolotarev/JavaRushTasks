package com.javarush.task.task31.task3102;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> result;
        Path path = Paths.get(root);
        try (Stream<Path> walk = Files.walk(path)) {
            result = walk.filter(Files::isRegularFile).map(Path::toString).collect(Collectors.toList());
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        List<String> list = getFileTree("/Users/denis/Downloads/testdir");
        list.forEach(System.out::println);
    }

}