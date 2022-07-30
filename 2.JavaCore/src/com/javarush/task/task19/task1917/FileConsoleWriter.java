package com.javarush.task.task19.task1917;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

/* 
Свой FileWriter
*/

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public static void main(String[] args) {
    }

    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(String str) throws IOException {
        this.fileWriter = new FileWriter(str);
    }

    public FileConsoleWriter(String str, boolean append) throws IOException {
        this.fileWriter = new FileWriter(str, append);
    }

    public FileConsoleWriter(FileDescriptor fd) throws IOException {
        this.fileWriter = new FileWriter(fd);
    }


    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        System.out.println(new String(cbuf).substring(off, off + len));
    }

    public void write(int c) throws IOException {
        this.fileWriter.write(c);
        System.out.println(c);
    }

    public void write(String str) throws IOException {
        this.fileWriter.write(str);
        System.out.println(str);
    }

    public void write(String str, int off, int len) throws IOException {
        this.fileWriter.write(str, off, len);
        System.out.println(str.substring(off, len + off));
    }

    public void write(char[] cbuf) throws IOException {
        this.fileWriter.write(cbuf);
        System.out.println(new String(cbuf));
    }

    public void close() throws IOException {
        this.fileWriter.close();
    }

}
