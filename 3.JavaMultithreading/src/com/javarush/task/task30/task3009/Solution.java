package com.javarush.task.task30.task3009;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
    }

    private static Set<Integer> getRadix(String number) {
        Set<Integer> result = new HashSet<>();
        BigInteger num = null;
        try {
            num = new BigInteger(number);
        } catch (NumberFormatException ignore) {
        }

        for (int i = 2; i <= 36; i++) {
            if (num == null) {
                break;
            }
            String numInNewBase = convertFromDecimalToAnyBase(num, i);
            String numInNewBaserReversed = (new StringBuilder(numInNewBase)).reverse().toString();
            if (numInNewBase.equals(numInNewBaserReversed)) {
                result.add(i);
            }
        }
        return result;
    }

    private static String convertFromDecimalToAnyBase(BigInteger num, int newBase) {
        StringBuilder result = new StringBuilder();
        BigInteger remainder;
        while (num.compareTo(BigInteger.ZERO) > 0) {
            remainder = num.mod(BigInteger.valueOf(newBase));
            if (newBase > 10 && newBase <= 36) {
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
                } else if (remainder.compareTo(BigInteger.valueOf(16)) == 0) {
                    result.append('g');
                } else if (remainder.compareTo(BigInteger.valueOf(17)) == 0) {
                    result.append('h');
                } else if (remainder.compareTo(BigInteger.valueOf(18)) == 0) {
                    result.append('i');
                } else if (remainder.compareTo(BigInteger.valueOf(19)) == 0) {
                    result.append('j');
                } else if (remainder.compareTo(BigInteger.valueOf(20)) == 0) {
                    result.append('k');
                } else if (remainder.compareTo(BigInteger.valueOf(21)) == 0) {
                    result.append('l');
                } else if (remainder.compareTo(BigInteger.valueOf(22)) == 0) {
                    result.append('m');
                } else if (remainder.compareTo(BigInteger.valueOf(23)) == 0) {
                    result.append('n');
                } else if (remainder.compareTo(BigInteger.valueOf(24)) == 0) {
                    result.append('o');
                } else if (remainder.compareTo(BigInteger.valueOf(25)) == 0) {
                    result.append('p');
                } else if (remainder.compareTo(BigInteger.valueOf(26)) == 0) {
                    result.append('q');
                } else if (remainder.compareTo(BigInteger.valueOf(27)) == 0) {
                    result.append('r');
                } else if (remainder.compareTo(BigInteger.valueOf(28)) == 0) {
                    result.append('s');
                } else if (remainder.compareTo(BigInteger.valueOf(29)) == 0) {
                    result.append('t');
                } else if (remainder.compareTo(BigInteger.valueOf(30)) == 0) {
                    result.append('u');
                } else if (remainder.compareTo(BigInteger.valueOf(31)) == 0) {
                    result.append('v');
                } else if (remainder.compareTo(BigInteger.valueOf(32)) == 0) {
                    result.append('w');
                } else if (remainder.compareTo(BigInteger.valueOf(33)) == 0) {
                    result.append('x');
                } else if (remainder.compareTo(BigInteger.valueOf(34)) == 0) {
                    result.append('y');
                } else if (remainder.compareTo(BigInteger.valueOf(35)) == 0) {
                    result.append('z');
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

}