package com.javarush.task.task30.task3001;

/*
Конвертер систем счислений
*/

import java.math.BigInteger;

public class Solution {

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        //напишите тут ваш код
        int base = number.getNumberSystem().getNumberSystemIntValue();
        int newBase = expectedNumberSystem.getNumberSystemIntValue();
        String num = number.getDigit();

        if (num.matches("^[.,-]+$") || !isBaseInNumberCorrect(base, num)) {
            throw new NumberFormatException();
        }

        if (base == newBase) {
            return number;
        } else {
            return new Number(expectedNumberSystem, convertNumberToNewBaseCustom(num, base, newBase));
        }
    }

    private static String convertNumberToNewBaseCustom(String num, int base, int newBase) {
        BigInteger decimalNumber = convertFromAnyBaseToDecimal(num, base);
        StringBuilder targetBase = new StringBuilder();
        try {
            targetBase.append(convertFromDecimalToAnyBase(decimalNumber, newBase));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return targetBase.toString();
    }

    private static BigInteger convertFromAnyBaseToDecimal(String num, int base) {
        if (base < 2 || (base > 10 && base != 16 && base != 12)) {
            throw new NumberFormatException();
        }

        BigInteger val = BigInteger.ZERO;
        BigInteger power = BigInteger.ONE;
        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = charToDecimal(num.charAt(i));
            if (digit < 0 || digit >= base) {
                throw new NumberFormatException();
            }
            val = power.multiply(BigInteger.valueOf(digit)).add(val);
            power = power.multiply(BigInteger.valueOf(base));
        }
        return val;
    }

    private static int charToDecimal(char ch) {
        if (ch >= '0' && ch <= '9') {
            return (int) ch - '0';
        } else {
            return (int) ch - 'a' + 10;
        }
    }

    private static String convertFromDecimalToAnyBase(BigInteger num, int newBase) {
        if ((newBase < 2 || newBase > 10) && newBase != 12 && newBase != 16) {
            throw new NumberFormatException("New base must be from 2 - 10 or 12 or 16");
        }

        StringBuilder result = new StringBuilder();
        BigInteger remainder;
        while (num.compareTo(BigInteger.ZERO) > 0) {
            remainder = num.mod(BigInteger.valueOf(newBase));
            if (newBase == 12 || newBase == 16) {
                if (remainder.compareTo(BigInteger.valueOf(10)) == 0) {
                    result.append('a');
                } else if (remainder.compareTo(BigInteger.valueOf(11)) == 0) {
                    result.append('b');
                } else if (remainder.compareTo(BigInteger.valueOf(12)) == 0) {
                    result.append('c');
                } else if (remainder.compareTo(BigInteger.valueOf(13)) == 0) {
                    result.append('d');
                } else if (remainder.compareTo(BigInteger.valueOf(14)) == 0) {
                    result.append('e');
                } else if (remainder.compareTo(BigInteger.valueOf(15)) == 0) {
                    result.append('f');
                } else {
                    result.append(remainder);
                }
            } else {
                result.append(remainder);
            }
            num = num.divide(BigInteger.valueOf(newBase));
        }
        return new StringBuilder(result.toString()).reverse().toString();
    }

    private static boolean isBaseInNumberCorrect(int base, String num) {

        String regex_base16 = "^[0-9a-f]+$";
        String regex_base12 = "^[0-9ab]+$";
        String regex_base10 = "^[0-9]+$";
        String regex_base9 = "^[0-8]+$";
        String regex_base8 = "^[0-7]+$";
        String regex_base7 = "^[0-6]+$";
        String regex_base6 = "^[0-5]+$";
        String regex_base5 = "^[0-4]+$";
        String regex_base4 = "^[0-3]+$";
        String regex_base3 = "^[0-2]+$";
        String regex_base2 = "^[01]+$";

        switch (base) {
            case 16:
                return num.matches(regex_base16);
            case 12:
                return num.matches(regex_base12);
            case 10:
                return num.matches(regex_base10);
            case 9:
                return num.matches(regex_base9);
            case 8:
                return num.matches(regex_base8);
            case 7:
                return num.matches(regex_base7);
            case 6:
                return num.matches(regex_base6);
            case 5:
                return num.matches(regex_base5);
            case 4:
                return num.matches(regex_base4);
            case 3:
                return num.matches(regex_base3);
            case 2:
                return num.matches(regex_base2);
        }
        return false;
    }

    public static void main(String[] args) {

        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._12);
        System.out.println(result);    //expected 1922a337264893

        number = new Number(NumberSystemType._2, "10110001010010100101011000101001010101");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected 2C52958A55

        number = new Number(NumberSystemType._2, "10110001010010100101011000101001010101");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._9);
        System.out.println(result);    // 605323556073

        number = new Number(NumberSystemType._2, "101100010100101");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    // 10110001010010

        number = new Number(NumberSystemType._16, "abcdefabcdefabcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._10);
        System.out.println(result);    //expected

//        number = new Number(NumberSystemType._16, "1311001abcdecfg101");
//        result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
//        System.out.println(result);    //Number format exception
    }

}
