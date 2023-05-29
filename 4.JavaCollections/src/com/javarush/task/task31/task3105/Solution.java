package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author Denis Zolotarev
 */
public class Solution {
    public static void main(String[] args) throws IOException {

        List<MyZipEntry> myZipEntries = new ArrayList<>();
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
                myZipEntries.add(new MyZipEntry(zipEntry.getName(), baos.toByteArray()));
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

            for (MyZipEntry myZipEntry : myZipEntries) {
                String zipEntryName = myZipEntry.getName();
                if (!zipEntryName.equals(appendFile)) {
                    zos.putNextEntry(new ZipEntry(zipEntryName));
                    zos.write(myZipEntry.getValue());
                    zos.closeEntry();
                }
            }
        }
    }
}
