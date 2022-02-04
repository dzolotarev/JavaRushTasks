package com.javarush.task.pro.task09.task0905;

public class temp {
    public static void main(String[] args) {
        int decimalNumber = 1000;

        int chastnoe = decimalNumber / 8; //126
        int ostatok = decimalNumber % 8; //2
        int octNumber = ostatok * (int) Math.pow(10, 0);// младший бит ; 2


        int chastnoe1 = chastnoe / 8; // 15
        int ostatok1 = chastnoe % 8; // 6

        int octNumber1 = octNumber + ostatok1 * (int) Math.pow(10, 1); //62

        int chastnoe2 = chastnoe1/8; //1
        int ostatok2 = chastnoe1%8; //7

        int octNumber2 = octNumber1 + ostatok2* (int)Math.pow(10,2); //762

        int chastnoe3 = chastnoe2/8; //0
        int ostatok3 = chastnoe2%8; //1
        int octNumber3 = octNumber2+ ostatok3* (int)Math.pow(10,3); //1762


        System.out.println(chastnoe);
        System.out.println(ostatok);
        System.out.println(octNumber);

        System.out.println(chastnoe1);
        System.out.println(ostatok1);
        System.out.println(octNumber1);

        System.out.println(chastnoe2);
        System.out.println(ostatok2);
        System.out.println(octNumber2);

        System.out.println(chastnoe3);
        System.out.println(ostatok3);
        System.out.println(octNumber3);
    }
}
