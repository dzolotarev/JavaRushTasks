package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) return;
        if (args[0].equals("-c")) {
            createEntry(args[1], args[2], args[3]);
        }
//        String greetings = "/Users/denis/Downloads/test1.txt";
//        byte[] bytes = greetings.getBytes();
//        InputStream inputStream = new ByteArrayInputStream(bytes);
//        System.setIn(inputStream);

    }

    public static void createEntry(String name, String price, String quantity) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(filePath));
        ArrayList<String> stringArray = new ArrayList<>();
        while (fileReader.ready()) {
            stringArray.add(fileReader.readLine());
        }
        fileReader.close();
        int lastIndex = 0;
        for (String string : stringArray) {
            int currentIndex = Integer.parseInt(string.substring(0, 8).trim());
            if (lastIndex < currentIndex) {
                lastIndex = currentIndex;
            }
        }
//            if (lastIndex == 99999999) {
//                lastIndex = 0;
//            } else {
        lastIndex++;
//            }
        String newEntry = String.format("\n%d%-30.30s%-8.8s%-4.4s", lastIndex, name, price, quantity);
        FileOutputStream fileWriter = new FileOutputStream(filePath, true);
        fileWriter.write(newEntry.getBytes());
        fileWriter.close();
    }
}

/*
другое решение
*/

//public class Solution {
//    public static class Product {
//        int id;
//        String name;
//        String price;
//        String quantity;
//
//        public Product(int id, String name, String price, String quantity) {
//            this.id = id;
//            this.name = name;
//            this.price = price;
//            this.quantity = quantity;
//        }
//
//        @Override
//        public String toString() {
//            return String.format("%-8d%-30s%-8s%-4s", id, name, price, quantity);
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        if (args.length == 0) {
//            return;
//        }
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = reader.readLine();
//
//        List<Product> products = new ArrayList<>();
//
//        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
//            while (fileReader.ready()) {
//                Product product = getProduct(fileReader.readLine());
//                products.add(product);
//            }
//        }
//
//        switch (args[0]) {
//            case "-c":
//                int id = 0;
//                for (Product product : products) {
//                    if (product.id > id) id = product.id;
//                }
//                String name = "";
//                for (int i = 1; i < args.length - 2; i++) {
//                    name += args[i] + " ";
//                }
//                if (name.length() > 30) {
//                    name = name.substring(0, 30);
//                }
//                String price = args[args.length - 2];
//                if (price.length() > 8) {
//                    price = price.substring(0, 8);
//                }
//                String quantity = args[args.length - 1];
//                if (quantity.length() > 4) {
//                    quantity = quantity.substring(0, 4);
//                }
//                Product product = new Product(++id, name.trim(), price, quantity);
//                try (FileWriter fileWriter = new FileWriter(fileName, true)) {
//                    fileWriter.write("\n");
//                    fileWriter.write(product.toString());
//                }
//        }
//    }
//
//    public static Product getProduct(String string) {
//        String id = string.substring(0, 8).trim();
//        String name = string.substring(8, 38).trim();
//        String price = string.substring(38, 46).trim();
//        String quantity = string.substring(46, 50).trim();
//        return new Product(Integer.parseInt(id), name, price, quantity);
//    }
//}
