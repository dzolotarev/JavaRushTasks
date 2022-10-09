package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        String fileName = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        try (BufferedReader fr = new BufferedReader(new FileReader(fileName))) {
            while (fr.ready()) {
                String line = fr.readLine();
                sb.append(" ").append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String str0 = sb.toString().trim();
        String[] tmpStr = str0.split(" ");
        List<String> list = new LinkedList<>(Arrays.asList(tmpStr));
        for (int i = 0; i < list.size(); i++) {
            String str1 = list.get(i);
            list.remove(i);
            for (int j = 0; j < list.size(); j++) {
                String str2 = list.get(j);
                if (str1.equals(str2) || str1.equals(new StringBuilder(str2).reverse().toString())) {
                    Pair pair = new Pair();
                    pair.first = str1;
                    pair.second = list.get(j);
                    result.add(pair);
                    list.remove(j);
                    break;
                }
            }
            i--;
        }
//        for (int i = 0; i < words.size(); i++) {
//            for (int j = 0; j < words.size(); ) {
//                if (i >= words.size()) {
//                    break;
//                }
//                if (words.get(j).equals(new StringBuilder(words.get(i)).reverse().toString()) && j != i) {
//                    Pair pair = new Pair();
//                    pair.first = words.get(j);
//                    pair.second = words.get(i);
//                    result.add(pair);
//                    words.remove(j);
//                    words.remove(i);
//                    j = 0;
//                } else
//                    j++;
//            }
//        }




        for (Pair pair : result) {
            System.out.println(pair.toString());
        }


    }

    public static class Pair {
        String first;
        String second;

        public Pair() {

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
