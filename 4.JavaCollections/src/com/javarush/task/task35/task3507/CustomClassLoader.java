package com.javarush.task.task35.task3507;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Denis Zolotarev
 */
public class CustomClassLoader extends ClassLoader {

    @Override
    public Class<?> findClass(String name) {
        Path path = Paths.get(name);
        byte[] b;
        try {
            b = Files.readAllBytes(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return defineClass(null, b, 0, b.length);
    }
}