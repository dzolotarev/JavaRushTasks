package com.javarush.task.task31.task3105;

/**
 * @author Denis Zolotarev
 */
public class MyZipEntry {
    private String name;
    private byte[] value;

    public MyZipEntry(String name, byte[] value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public byte[] getValue() {
        return value;
    }
}
