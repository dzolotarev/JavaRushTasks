package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner reader = new Scanner(System.in);
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        BigInteger a1 = BigInteger.valueOf(a);
        BigInteger b1 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(a1);
        System.out.println(gcd.intValue());
    }
}
