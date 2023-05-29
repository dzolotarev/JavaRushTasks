package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipInputStream;

/* 
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        List<String> fileList = getSortedFileList(args);
        List<FileInputStream> inputStreams = getInputStreams(fileList);

        ZipInputStream zis = new ZipInputStream(new SequenceInputStream(Collections.enumeration(inputStreams)));

        try (FileOutputStream fos = new FileOutputStream(args[0])) {
            zis.getNextEntry();
            byte[] buffer = new byte[4096];
            int len;
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            fos.flush();
            zis.close();
        }
    }

    private static List<FileInputStream> getInputStreams(List<String> fileList) throws FileNotFoundException {
        List<FileInputStream> inputStreams = new ArrayList<>();
        for (String file : fileList) {
            inputStreams.add(new FileInputStream(file));
        }
        return inputStreams;
    }


    private static List<String> getSortedFileList(String[] args) {
        List<String> fileList = Arrays.asList(args).subList(1, args.length);
        Collections.sort(fileList);
        return fileList;
    }

    private static File mergeFiles(List<File> fileList) throws IOException {
        File tempFile = File.createTempFile("tmpZipFile", ".zip");
        tempFile.deleteOnExit();
        FileOutputStream fos = new FileOutputStream(tempFile);
        for (File file : fileList) {
            try (FileInputStream fis = new FileInputStream(file);
            ) {
                byte[] b = new byte[fis.available()];
                fis.read(b);
                fos.write(b);
                fos.flush();
            }
        }
        fos.close();
        return tempFile;
    }
}