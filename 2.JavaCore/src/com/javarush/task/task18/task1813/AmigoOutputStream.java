package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    private FileOutputStream fileOutputStream;
    public static String fileName = "C:/tmp/result.txt";


    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {

        super(fileName, true);
        this.fileOutputStream = fileOutputStream;
    }

    public void close() throws IOException {

        byte[] buffer = "JavaRush © All rights reserved.".getBytes();
        fileOutputStream.flush();
        fileOutputStream.write(buffer);
        fileOutputStream.close();
    }

    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    public void write(byte[] b, int off, int len) throws IOException {
        fileOutputStream.write(b, off, len);
    }

    public void write(byte[] b) throws IOException {
        fileOutputStream.write(b);
    }

    public void write(int b) throws IOException {
        fileOutputStream.write(b);
    }


    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
