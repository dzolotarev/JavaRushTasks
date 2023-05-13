package com.javarush.task.task31.task3101;

/*
Проход по дереву файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("Неверные параметры командной строки");
        }

        File rootPath = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParentFile() + "/" + "allFilesContent.txt");

        if (FileUtils.isExist(allFilesContent)) {
            FileUtils.deleteFile(allFilesContent);
        }
            FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(allFilesContent))) {
            new Solution().readAllAndSaveFiles(rootPath,bufferedWriter);
        }
    }

    private void readAllAndSaveFiles(File filePath, Writer bufferedWriter) throws IOException {
        if (filePath.isDirectory()) {
            File[] files = filePath.listFiles();
            if (files != null) {
                for (File file : files) {
                    readAllAndSaveFiles(file, bufferedWriter);
                }
            }
        } else {
            if (filePath.length() <= 50) {
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
                    while (bufferedReader.ready()) {
                        bufferedWriter.write(bufferedReader.readLine());
                    }
                    bufferedWriter.write('\n');
                }
            }
        }
    }
}