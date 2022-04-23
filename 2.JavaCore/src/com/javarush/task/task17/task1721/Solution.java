package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    public static String firstFileName;
    public static String secondFileName;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        firstFileName = reader.readLine();
        secondFileName = reader.readLine();
        reader.close();

        String tmpString = "";
        BufferedReader reader1 = new BufferedReader(new FileReader(firstFileName));
        while ((tmpString = reader1.readLine()) != null) {
            allLines.add(tmpString);
        }
        reader1.close();

        String tmpString1 = "";
        BufferedReader reader2 = new BufferedReader(new FileReader(secondFileName));
        while ((tmpString1 = reader2.readLine()) != null) {
            forRemoveLines.add(tmpString1);
            //allLines.add(tmpString1);
        }
        reader2.close();
        new Solution().joinData();

    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }

}
