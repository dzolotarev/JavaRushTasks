package com.javarush.task.task30.task3013;

/* 
Битовые операции
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = Integer.MAX_VALUE - 133;
    //    int number = 1034557826;
        System.out.println(Integer.toString(number, 2));

        System.out.println(solution.resetLowerBits(number));
        String result = Integer.toString(solution.resetLowerBits(number), 2);
        System.out.println(result);
    }

    public int resetLowerBits(int number) {
        //напишите тут ваш код

        // check for the set bits
        number = number | (number >> 1);
        number = number | (number >> 2);
        number = number | (number >> 4);
        number = number | (number >> 8);
        number = number | (number >> 16);

        // Then we remove all but the top bit by xor'ing the
        // string of 1's with that string of 1's shifted one to
        // the left, and we end up with just the one top bit
        // followed by 0's.


        //        return number ^ (number >> 1);
//        A NAND B = NOT(A AND B)
//        A XOR B = (A NAND (A NAND B)) NAND (B NAND (A NAND B))

//          A NAND B = ~(number & (number >> 1))
        //       (A NAND (A NAND B)) = ~(number & (~(number & (number >> 1))))
        //      (B NAND (A NAND B)) = ~((number >> 1) & (~(number & (number >> 1))))
        return ~((~(number & (~(number & (number >> 1))))) & (~((number >> 1) & (~(number & (number >> 1))))));
    }
}