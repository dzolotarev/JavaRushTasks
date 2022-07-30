package com.javarush.task.task20.task2025;

public class MyNewTest4 {
    public static void main(String[] args) {
        int x = 1, y = 1;
        while (x<=9  ){
            while (y<=9){
                System.out.printf("%d ", x*y);
                y++;
            }
            x++;
            System.out.println();
            y=1;

        }
    }
}
