package com.javarush.task.task31.task3105;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/

public class Solution2 {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Pass file names");
        }
        File fileName = new File(args[0]);
        File zipFile = new File(args[1]);

        appendFileToArchive(fileName, zipFile);
    }

    private static void appendFileToArchive(File fileName, File zipFile) throws IOException {
        File tempZipFile = File.createTempFile("tmpZipFile", ".zip");
        tempZipFile.deleteOnExit();
        String appendFile = "new" + File.separator + fileName.getName();
        ZipEntry zipEntry;
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(tempZipFile));
             ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
             FileInputStream fis = new FileInputStream(fileName)) {

            while ((zipEntry = zis.getNextEntry()) != null) {
                if (!zipEntry.getName().equals(appendFile)) {
                    zos.putNextEntry(zipEntry);
                    byte[] buffer = new byte[65536];
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        zos.write(buffer, 0, len);
                    }
                }
            }
            zos.putNextEntry(new ZipEntry(appendFile));
            byte[] buffer = new byte[65536];
            int len;
            while ((len = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }
            zos.closeEntry();
            zis.closeEntry();
        }
        boolean done = tempZipFile.renameTo(zipFile);
    }
}
