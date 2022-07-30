package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) {
        String filePath1 = "";
        String filePath2 = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            filePath1 = reader.readLine();
            filePath2 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader in = new FileReader(filePath1); BufferedReader reader = new BufferedReader(in);
             FileWriter writer = new FileWriter(filePath2)) {


            {
                String[] array = new String[0];

                // DecimalFormat decimalFormat = new DecimalFormat( "#.#" );


                while (reader.ready()) {
                    String line = reader.readLine();
                    array = line.split(" ");
                }

                int[] resultArray = new int[array.length];

                for (int i = 0; i < resultArray.length; i++) {
                    //resultArray[i] = String.format("%.0f",array[i]);
                    //resultArray[i] = decimalFormat.format(array[i]);
                    resultArray[i] = (int) Math.round(Double.parseDouble(array[i]));
                }


                //  String arrayToString = Arrays.toString(resultArray).replaceAll("\\[|\\]", ",");
                String arrayToString = IntStream.of(resultArray)
                        .mapToObj(Integer::toString)
                        .collect(Collectors.joining(" "));

                writer.write(arrayToString);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
