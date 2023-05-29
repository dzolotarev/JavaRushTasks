package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Добавление файла в архив
*/

public class Solution22 {
    public static void main(String[] args) throws IOException {
        Map<ZipEntry, ByteArrayOutputStream> zipEntryMap = new HashMap<>();
        try (FileInputStream zipFile = new FileInputStream(args[1]);
             ZipInputStream zis = new ZipInputStream(zipFile)) {
            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {
                byte[] buffer = new byte[65536];
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int bytes;
                while ((bytes = zis.read(buffer, 0, buffer.length)) > 0) {
                    baos.write(buffer, 0, bytes);
                }
                zipEntryMap.put(zipEntry, baos);
                baos.close();
            }
        }

        try (FileOutputStream zipFileOut = new FileOutputStream(args[1]);
             ZipOutputStream zos = new ZipOutputStream(zipFileOut)) {

            File fileName = new File(args[0]);
            String appendFile = "new" + File.separator + fileName.getName();
            zos.putNextEntry(new ZipEntry(appendFile));
            Files.copy(fileName.toPath(), zos);
            zos.closeEntry();

            for (Map.Entry<ZipEntry, ByteArrayOutputStream> zipEntryByteArrayOutputStreamEntry : zipEntryMap.entrySet()) {
                ZipEntry entry = zipEntryByteArrayOutputStreamEntry.getKey();
                if (!entry.getName().equals(appendFile)) {
                    ByteArrayOutputStream value = zipEntryByteArrayOutputStreamEntry.getValue();
                    zos.putNextEntry(entry);
                    zos.write(value.toByteArray());
                    zos.closeEntry();
                }
            }
        }
    }
}
