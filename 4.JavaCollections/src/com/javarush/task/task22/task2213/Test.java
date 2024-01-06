package com.javarush.task.task22.task2213;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Denis Zolotarev
 */
public class Test {
    //ширина и высота
    int width;
    int height;

    //матрица поля: 1 - клетка занята, 0 - свободна
    int[][] matrix;

    public Test(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new int[height][width];
    }

    public void removeAll() {
        List<int[]> rowList = new ArrayList<>();
        for (int y = 0; y < height; y++) {
            boolean isFull = true;
            for (int x = 0; x < width; x++) {
                if (matrix[y][x] == 0) {
                    isFull = false;
                    break;
                }
            }
            if (!isFull) {
                rowList.add(matrix[y]);
            }
        }
        int numberOfDeletedRows = height - rowList.size();
        for (int i = 0; i < numberOfDeletedRows; i++) {
            rowList.add(0, new int[width]);
        }

        for (int y = 0; y < height; y++) {
            matrix[y] = rowList.get(y);
        }
    }

    public static void main(String[] args) {
        Test test = new Test(10, 20);
        for (int y = 0; y < test.height; y++) {
            for (int x = 0; x < test.width; x++) {
                System.out.printf(" %d ", test.matrix[y][x]);
                if (y % 2 == 0) {
                    test.matrix[y][x] = 1;
                } else if (x%2 == 0) {
                    test.matrix[y][x] = 1;
                }
            }
            System.out.println();
        }
        System.out.println("----------------------");
        for (int y = 0; y < test.height; y++) {
            for (int x = 0; x < test.width; x++) {
                System.out.printf(" %d ", test.matrix[y][x]);
            }
            System.out.println();
        }

        test.removeAll();
        System.out.println("----------------------");
        for (int y = 0; y < test.height; y++) {
            for (int x = 0; x < test.width; x++) {
                System.out.printf(" %d ", test.matrix[y][x]);
            }
            System.out.println();
        }


    }
}
