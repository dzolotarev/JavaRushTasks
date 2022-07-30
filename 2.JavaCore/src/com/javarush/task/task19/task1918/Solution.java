package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/* 
Знакомство с тегами
*/

public class Solution {
    public static String tag;
    public static String string;

    public static void main(String[] args) throws IOException {
        if (args.length == 0) return;
        tag = args[0];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        string = getStringFromFile(file); //собираем одну строку из множества строк

        int tagOpen = 0;
        while (tagOpen != -1) {
            tagOpen = string.indexOf("<" + tag, tagOpen);
            if (tagOpen != -1) {
                tagParser(tagOpen); //парсим строку
            } else break;
            tagOpen++;
        }
    }

//   //не очень рабочее решение
//    public static void tagsParser(String str, String tag) {
//
//        int openTagIndex = -1;
//
//        while (true) {
//            openTagIndex = str.indexOf("<" + tag, openTagIndex + 1);
//            int closeTagIndex = str.indexOf("</" + tag + ">", openTagIndex + 1);
//            int nextOpenTagIndex = str.indexOf("<" + tag, openTagIndex + 1);
//
//            if (openTagIndex != -1 && nextOpenTagIndex != -1 &&  nextOpenTagIndex < closeTagIndex) {
//                int nextCloseTagIndex = str.indexOf("</" + tag + ">", closeTagIndex + 1);
//                System.out.println(str.substring(openTagIndex, nextCloseTagIndex) + "</" + tag + ">");
//                openTagIndex = str.indexOf("<" + tag, openTagIndex + 1);
//            } else if (openTagIndex == -1) return;
//            System.out.println(str.substring(openTagIndex, closeTagIndex) + "</" + tag + ">");
//        }
//    }

    public static String getStringFromFile(String path) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        StringBuilder sb = new StringBuilder();
        while (bufferedReader.ready()) {
            String s = bufferedReader.readLine();
            sb.append(s);
        }
        bufferedReader.close();
        return sb.toString();
    }

    public static void tagParser(int index) {
        Stack<Integer> st = new Stack<>();

        for (int i = index; i < string.length(); i++) {
            if (string.charAt(i) == '<' && string.charAt(i + 1) != '/') {
                st.push(i);
            } else if (string.charAt(i) == '<' && string.charAt(i + 1) == '/') {
                st.pop();
                if (st.empty()) {
                    System.out.println(string.substring(index, i+tag.length()+3));
                    return;
                }
            }
        }
    }
}
