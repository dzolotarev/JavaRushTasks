package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) {
        if (args.length == 0) return;
        String filePath = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            filePath = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (args[0].equals("-d")) {
            deleteEntry(args[1], filePath);
        } else if (args[0].equals("-u")) {
            updateEntry(args[1], args[2], args[3], args[4], filePath);
        }
    }

    public static void deleteEntry(String id, String path) {
        ArrayList<String> stringArray = new ArrayList<>();
        readFileToArray(stringArray,path);

        try (FileOutputStream fileWriter = new FileOutputStream(path);) {

            for (String string : stringArray) {
                if (!(id.equals(string.substring(0, 8).trim()))) {
                    fileWriter.write((string + "\n").getBytes());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateEntry(String id, String name, String price, String quantity, String path) {
        ArrayList<String> stringArray = new ArrayList<>();
        readFileToArray(stringArray,path);

        try (FileOutputStream fileWriter = new FileOutputStream(path);) {

            for (String string : stringArray) {
                if (!(id.equals(string.substring(0, 8).trim()))) {
                    fileWriter.write((string + "\n").getBytes());
                }
                else {
                    String updatedString = String.format("%-8.8s%-30.30s%-8.8s%-4.4s", id, name, price, quantity);
                    fileWriter.write((updatedString + "\n").getBytes());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void readFileToArray(ArrayList<String> array, String path){
        try (BufferedReader fileReader = new BufferedReader(new FileReader(path))) {

            while (fileReader.ready()) {
                array.add(fileReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


///*
//Прайсы 2 другое решение
//*/
//
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
//            case "-u": {
//                int id = Integer.parseInt(args[1]);
//                String name = "";
//                for (int i = 2; i < args.length - 2; i++) {
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
//                Product productToUpdate = null;
//                for (Product product : products) {
//                    if (product.id == id) productToUpdate = product;
//                }
//                if (productToUpdate != null) {
//                    productToUpdate.name = name;
//                    productToUpdate.price = price;
//                    productToUpdate.quantity = quantity;
//                }
//                break;
//            }
//            case "-d": {
//                int id = Integer.parseInt(args[1]);
//                Product productToDelete = null;
//                for (Product product : products) {
//                    if (product.id == id) productToDelete = product;
//                }
//                if (productToDelete != null) products.remove(productToDelete);
//                break;
//            }
//        }
//
//        try (FileWriter fileWriter = new FileWriter(fileName)) {
//            for (Product product : products) {
//                fileWriter.write(product.toString());
//                fileWriter.write("\n");
//            }
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

