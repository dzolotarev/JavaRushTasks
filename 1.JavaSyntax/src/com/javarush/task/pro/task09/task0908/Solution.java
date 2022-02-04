package com.javarush.task.pro.task09.task0908;

import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        String hexNumber = "";
        if (binaryNumber == null || binaryNumber.length() == 0) {
            return hexNumber;
        }
        String regex = "[01]+"; // "[0-9]|[a-f]"
        if (!Pattern.compile(regex).matcher(binaryNumber).matches()) {
            return hexNumber;
        } else {
            String binaryNum = "";
            if (binaryNumber.length() % 4 > 0) {
                for (int i = 0; i < (((binaryNumber.length() / 4 + 1) * 4) - binaryNumber.length()); i++) {
                    binaryNum = binaryNum + "0";
                }
                binaryNum = binaryNum + binaryNumber;
            } else {
                binaryNum = binaryNumber;
            }

            for (int i = 0; i < binaryNum.length(); i += 4) {
                String binaryPartNum = binaryNum.substring(i, i + 4);
//            switch (binaryPartNum) {
//                case ("0000"):
//                    hexNumber = hexNumber + "0";
//                    break;
//                case ("0001"):
//                    hexNumber = hexNumber + "1";
//                    break;
//                case ("0010"):
//                    hexNumber = hexNumber + "2";
//                    break;
//                case ("0011"):
//                    hexNumber = hexNumber + "3";
//                    break;
//                case ("0100"):
//                    hexNumber = hexNumber + "4";
//                    break;
//                case ("0101"):
//                    hexNumber = hexNumber + "5";;
//                    break;
//                case ("0110"):
//                    hexNumber = hexNumber + "6";;
//                    break;
//                case ("0111"):
//                    hexNumber = hexNumber + "7";;
//                    break;
//                case ("1000"):
//                    hexNumber = hexNumber + "8";;
//                    break;
//                case ("1001"):
//                    hexNumber = hexNumber + "9";;
//                    break;
//                case ("1010"):
//                    hexNumber = hexNumber + "a";;
//                    break;
//                case ("1011"):
//                    hexNumber = hexNumber + "b";
//                    break;
//                case ("1100"):
//                    hexNumber = hexNumber + "c";
//                    break;
//                case ("1101"):
//                    hexNumber = hexNumber + "d";
//                    break;
//                case ("1110"):
//                    hexNumber = hexNumber + "e";
//                    break;
//                case ("1111"):
//                    hexNumber = hexNumber + "f";
//                    break;
//                default:
//                    System.out.println("Error");
//                    break;
//            }
                if (binaryPartNum.equals("0000")) {
                    hexNumber = hexNumber + "0";
                }
                if (binaryPartNum.equals("0001")) {
                    hexNumber = hexNumber + "1";
                }
                if (binaryPartNum.equals("0010")) {
                    hexNumber = hexNumber + "2";
                }
                if (binaryPartNum.equals("0011")) {
                    hexNumber = hexNumber + "3";
                }
                if (binaryPartNum.equals("0100")) {
                    hexNumber = hexNumber + "4";
                }
                if (binaryPartNum.equals("0101")) {
                    hexNumber = hexNumber + "5";
                }
                if (binaryPartNum.equals("0110")) {
                    hexNumber = hexNumber + "6";
                }
                if (binaryPartNum.equals("0111")) {
                    hexNumber = hexNumber + "7";
                }
                if (binaryPartNum.equals("1000")) {
                    hexNumber = hexNumber + "8";
                }
                if (binaryPartNum.equals("1001")) {
                    hexNumber = hexNumber + "9";
                }
                if (binaryPartNum.equals("1010")) {
                    hexNumber = hexNumber + "a";
                }
                if (binaryPartNum.equals("1011")) {
                    hexNumber = hexNumber + "b";
                }
                if (binaryPartNum.equals("1100")) {
                    hexNumber = hexNumber + "c";
                }
                if (binaryPartNum.equals("1101")) {
                    hexNumber = hexNumber + "d";
                }
                if (binaryPartNum.equals("1110")) {
                    hexNumber = hexNumber + "e";
                }
                if (binaryPartNum.equals("1111")) {
                    hexNumber = hexNumber + "f";
                }
            }
            return hexNumber;
        }

    }

    public static String toBinary(String hexNumber) {
        String binNumber = "";
        if (hexNumber == null || hexNumber.length() == 0) {
            return binNumber;
        }
        String regex = "[0-9a-f]+"; //"[01]+";
        if (!Pattern.compile(regex).matcher(hexNumber).matches()) {
            return binNumber;
        }

            for (int i = 0; i < hexNumber.length(); i++) {
                String hexPart = String.valueOf(hexNumber.charAt(i));
                if (hexPart.equals("0")) {
                    binNumber = binNumber + "0000";
                }
                if (hexPart.equals("1")) {
                    binNumber = binNumber + "0001";
                }
                if (hexPart.equals("2")) {
                    binNumber = binNumber + "0010";
                }
                if (hexPart.equals("3")) {
                    binNumber = binNumber + "0011";
                }
                if (hexPart.equals("4")) {
                    binNumber = binNumber + "0100";
                }
                if (hexPart.equals("5")) {
                    binNumber = binNumber + "0101";
                }
                if (hexPart.equals("6")) {
                    binNumber = binNumber + "0110";
                }
                if (hexPart.equals("7")) {
                    binNumber = binNumber + "0111";
                }
                if (hexPart.equals("8")) {
                    binNumber = binNumber + "1000";
                }
                if (hexPart.equals("9")) {
                    binNumber = binNumber + "1001";
                }
                if (hexPart.equals("a")) {
                    binNumber = binNumber + "1010";
                }
                if (hexPart.equals("b")) {
                    binNumber = binNumber + "1011";
                }
                if (hexPart.equals("c")) {
                    binNumber = binNumber + "1100";
                }
                if (hexPart.equals("d")) {
                    binNumber = binNumber + "1101";
                }
                if (hexPart.equals("e")) {
                    binNumber = binNumber + "1110";
                }
                if (hexPart.equals("f")) {
                    binNumber = binNumber + "1111";
                }
            }
            return binNumber;
        }
    }
