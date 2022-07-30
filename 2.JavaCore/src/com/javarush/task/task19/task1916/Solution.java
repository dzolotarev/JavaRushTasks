package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String oldFileName = console.readLine();
        String newFileName = console.readLine();
        console.close();

        List<String> oldFileLines = readFileLines(oldFileName);
        List<String> newFileLines = readFileLines(newFileName);

        int oldFileLine = 0;
        int newFileLine = 0;

        while ((oldFileLine < oldFileLines.size()) && (newFileLine < newFileLines.size())) {

            if (oldFileLines.get(oldFileLine).equals(newFileLines.get(newFileLine))) {
                lines.add(new LineItem(Type.SAME, oldFileLines.get(oldFileLine)));
                oldFileLine++;
                newFileLine++;
            } else if ((newFileLine + 1 < newFileLines.size()) && oldFileLines.get(oldFileLine).equals(newFileLines.get(newFileLine + 1))) {
                lines.add(new LineItem(Type.ADDED, newFileLines.get(newFileLine)));
                newFileLine++;
            } else if ((oldFileLine + 1 < oldFileLines.size()) && oldFileLines.get(oldFileLine + 1).equals(newFileLines.get(newFileLine))) {
                lines.add(new LineItem(Type.REMOVED, oldFileLines.get(oldFileLine)));
                oldFileLine++;
            }
        }

        while (oldFileLine < (oldFileLines.size())) {
            lines.add(new LineItem(Type.REMOVED, oldFileLines.get(oldFileLine)));
            oldFileLine++;
        }
        while (newFileLine < (newFileLines.size())) {
            lines.add(new LineItem(Type.ADDED, newFileLines.get(newFileLine)));
            newFileLine++;
        }
    }

    static List<String> readFileLines(String fileName) throws IOException {
        BufferedReader fReader = new BufferedReader(new FileReader(fileName));
        List<String> fileLines = new ArrayList<String>();
        String line;
        while ((line = fReader.readLine()) != null) {
            fileLines.add(line);
        }
        fReader.close();
        return fileLines;
    }




//        String file1 = "";
//        String file2 = "";
//        try (BufferedReader read = new BufferedReader(new InputStreamReader(System.in))) {
//            file1 = read.readLine();
//            file2 = read.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        List<String> stringArray1 = new ArrayList<>();
//        List<String> stringArray2 = new ArrayList<>();
//
//
//        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
//             BufferedReader reader2 = new BufferedReader(new FileReader(file2))) {
//            String s1 = "";
//            String s2 = "";
//            while (reader1.ready()) {
//                stringArray1.add(reader1.readLine());
//            }
//            while (reader2.ready()) {
//                stringArray2.add(reader2.readLine());
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//
//
//        int index = 0;
//        int step = stringArray1.size();
//
//        while (step > 0) {
//            if (stringArray1.get(index).equals(stringArray2.get(index))) {
//                lines.add(new LineItem(Type.SAME, stringArray1.get(index)));
//                System.out.println("SAME " + stringArray1.get(index));
//                stringArray1.remove(index);
//                stringArray2.remove(index);
//                step--;
//                //index++;
//            } else if (stringArray1.get(index + 1).equals(stringArray2.get(index))) {
//                lines.add(new LineItem(Type.REMOVED, stringArray1.get(index)));
//                System.out.println("REMOVED " + stringArray1.get(index));
//                stringArray1.remove(index);
//                step--;
//                //index++;
//            } else if (stringArray1.get(index).equals(stringArray2.get(index + 1))) {
//                lines.add(new LineItem(Type.ADDED, stringArray2.get(index)));
//                System.out.println("ADDED " + stringArray2.get(index));
//                stringArray2.remove(index);
//                step--;
//                //index++;
//            }
//        }
//        if (step==0 && stringArray1.size() == 0 && stringArray2.size() != 0) { //
//            lines.add(new LineItem(Type.ADDED, stringArray2.get(index)));
//            System.out.println("ADDED " + stringArray2.get(index));
//
//        } else {
//            lines.add(new LineItem(Type.REMOVED, stringArray1.get(index)));
//            System.out.println("REMOVED " + stringArray1.get(index));
// }


//        List<String> minArray;
//        if (stringArray1.size() > stringArray2.size()) {
//            minArray = stringArray2;
//        } else {
//            minArray = stringArray1;
//        }
//
//        for (int i = 0; i <= minArray.size(); i++) {
//            if (i < minArray.size()) {
//                if (stringArray2.get(i).equals(stringArray1.get(i))) {
//                    lines.add(new LineItem(Type.SAME, stringArray1.get(i)));
//                    finalArray.add("SAME " + stringArray1.get(i));
//                } else if (stringArray1.get(i).equals(stringArray2.get(i + 1)) && !(stringArray2.get(i).equals(stringArray1.get(i + 1)))) {
//                    lines.add(new LineItem(Type.ADDED, stringArray2.get(i)));
//                    lines.add(new LineItem(Type.SAME, stringArray1.get(i)));
//                    finalArray.add("ADDED " + stringArray2.get(i));
//                    finalArray.add("SAME " + stringArray1.get(i));
//                    stringArray2.remove(i);
//                } else if (stringArray2.get(i).equals(stringArray1.get(i + 1)) && !(stringArray1.get(i).equals(stringArray2.get(i + 1)))) {
//                    lines.add(new LineItem(Type.REMOVED, stringArray1.get(i)));
//                    lines.add(new LineItem(Type.SAME, stringArray2.get(i)));
//                    finalArray.add("REMOVED " + stringArray1.get(i));
//                    finalArray.add("SAME " + stringArray2.get(i));
//                    stringArray1.remove(i);
//                }
//            }
//            if (i == minArray.size()) {
//                if (stringArray1.size() > stringArray2.size()) {
//                    lines.add(new LineItem(Type.REMOVED, stringArray1.get(i)));
//                    finalArray.add("REMOVED " + stringArray1.get(i));
//                } else if (stringArray1.size() < stringArray2.size()) {
//                    lines.add(new LineItem(Type.ADDED, stringArray2.get(i)));
//                    finalArray.add("ADDED " + stringArray2.get(i));
//                }
//            }
//
//        }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
