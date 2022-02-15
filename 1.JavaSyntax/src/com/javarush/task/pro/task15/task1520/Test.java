package com.javarush.task.pro.task15.task1520;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Test {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://google.ru");
        InputStream input = url.openStream();
        byte[] buffer = input.readAllBytes();
        String str = new String(buffer);
        System.out.println(str);
    }
}
