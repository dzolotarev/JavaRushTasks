package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Denis Zolotarev
 */
public class Solution2 {

    public static void main(String[] args) throws IOException {
        Path path;
        AtomicInteger dirsCounter = new AtomicInteger(0);
        AtomicInteger filesCounter = new AtomicInteger(0);
        AtomicLong totalSize = new AtomicLong(0);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            path = Paths.get(reader.readLine());
        }

        if (!Files.isDirectory(path)) {
            System.out.println(path + " - не папка");
        } else {
            Files.walkFileTree(path, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
                    new FileVisitor<>() {
                        @Override
                        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                            if (!dir.equals(path)) {
                                dirsCounter.incrementAndGet();
                            }
                            return FileVisitResult.CONTINUE;
                        }

                        @Override
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                            if (!Files.isDirectory(file)) {
                                filesCounter.incrementAndGet();
                                totalSize.addAndGet(Files.size(file));
                            }
                            return FileVisitResult.CONTINUE;
                        }

                        @Override
                        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                            throw exc;
                        }

                        @Override
                        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                            if (exc != null)
                                throw exc;
                            return FileVisitResult.CONTINUE;
                        }
                    });
            System.out.println("Всего папок - " + dirsCounter);
            System.out.println("Всего файлов - " + filesCounter);
            System.out.println("Общий размер - " + totalSize);
        }

    }
}
