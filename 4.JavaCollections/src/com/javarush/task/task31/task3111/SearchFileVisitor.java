package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private final List<Path> foundFiles = new ArrayList<>();
    private int minSize = -1;
    private int maxSize = -1;
    private String partOfContent = null;
    private String partOfName = null;


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        String contentAsString = new String(content);
        if ((partOfName == null || file.getFileName().toString().contains(partOfName)) && (minSize < 0 || minSize < attrs.size())
                && (maxSize < 0 || attrs.size() < maxSize) && (partOfContent == null || contentAsString.contains(this.partOfContent))) {
            foundFiles.add(file);
        }
        //return super.visitFile(file, attrs);
        return FileVisitResult.CONTINUE;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}