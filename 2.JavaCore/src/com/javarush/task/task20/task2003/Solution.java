package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* 
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код
        PrintWriter pw = new PrintWriter(outputStream);
        Properties pr = new Properties();
        for (Map.Entry<String, String> e : runtimeStorage.entrySet()) {
            pr.setProperty(e.getKey(), e.getValue());
        }
        pr.store(pw,"");
        pw.flush();
    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
        Properties pr = new Properties();
        InputStreamReader reader = new InputStreamReader(inputStream);
        while (reader.ready()) {
            pr.load(reader);
        }
        reader.close();
        Set<String> keys = pr.stringPropertyNames();

        for (String key : keys) {
            String value = pr.getProperty(key);
            runtimeStorage.put(key, value);
        }

    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(runtimeStorage);
    }
}
