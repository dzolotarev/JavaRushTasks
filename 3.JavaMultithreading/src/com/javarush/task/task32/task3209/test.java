package com.javarush.task.task32.task3209;

import java.io.File;

public class test {
    public static void main(String[] args) {
        File f = new File("/test/file.html");
        System.out.println(f.getName().toLowerCase().substring(f.getName().lastIndexOf(".")));
        System.out.println(f.getName().toLowerCase().substring(f.getName().lastIndexOf(".")).equals(".html") || f.getName().toLowerCase().substring(f.getName().lastIndexOf(".")).equals(".htm"));
    }
}
