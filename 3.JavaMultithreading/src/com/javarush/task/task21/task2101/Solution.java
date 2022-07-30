package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/

public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000

    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] netAdreess = new byte[4];
        for (int i = 0; i < netAdreess.length; i++) {
            netAdreess[i] = (byte) (ip[i] & mask[i]);
        }
        return netAdreess;
    }

    public static void print(byte[] bytes) {
        for (int i = 0; i < bytes.length; i++) {
            if (i < bytes.length - 1) {
                toBinary(bytes[i]);
                System.out.print(" ");
            } else toBinary(bytes[i]);

        }
        System.out.println();
    }

    public static void toBinary(byte dec) {
        int decimal = Byte.toUnsignedInt(dec);
        int binary[] = new int[8];
        int index = 0;
        while (decimal > 0) {
            binary[index++] = decimal % 2;
            decimal = decimal / 2;
        }
        for (int i = binary.length - 1; i >= 0; i--) {
            System.out.print(binary[i]);
        }

    }

}
