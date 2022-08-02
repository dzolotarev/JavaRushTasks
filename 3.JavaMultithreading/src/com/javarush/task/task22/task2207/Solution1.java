package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/*
Обращенные слова WRONG
*/

public class Solution1 {
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

        String[] splitted = sb.toString().trim().split(" ");

        int i = 0;
        int j = 1;
        while (i < splitted.length) {
            while (j < splitted.length) {
                if (splitted[i].equals(splitted[j]) || splitted[i].equals(new StringBuilder(splitted[j]).reverse().toString())) {
                    Pair pair = new Pair();
                    pair.first = splitted[i];
                    pair.second = splitted[j];
                    result.add(pair);
                    i++;
                    j++;
                }
                j++;
                break;
            }
            i++;
        }

        for (Pair pair:result) {
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
