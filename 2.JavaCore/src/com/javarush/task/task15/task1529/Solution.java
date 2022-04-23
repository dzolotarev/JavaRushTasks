package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        try {
            Solution.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static CanFly result;

    public static void reset() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key;
        key = reader.readLine();
            if ("plane".equals(key)) {
                result = new Plane(Integer.parseInt(reader.readLine()));
            } else if ("helicopter".equals(key)) {
                result = new Helicopter();
            }
        reader.close();
        }
    }
