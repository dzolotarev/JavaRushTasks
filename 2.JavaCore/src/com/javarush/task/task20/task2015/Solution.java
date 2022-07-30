package com.javarush.task.task20.task2015;

import java.io.*;

/* 
Переопределение сериализации
*/

public class Solution implements Runnable, Serializable {
    private transient Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, doesn't matter what
        System.out.println("Please, wait...");
        try {
            Thread.sleep(speed * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello, World!!");
    }

    /**
     * Переопределяем сериализацию.
     * Для этого необходимо объявить методы:
     * private void writeObject(ObjectOutputStream out) throws IOException
     * private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     * Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        runner = new Thread(this);
        runner.start();

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Solution solution2 = new Solution(1);
//        FileOutputStream outputStream = new FileOutputStream("/Users/denis/Downloads/test6.txt");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//        objectOutputStream.writeObject(solution2);
//        objectOutputStream.close();

        FileInputStream inputStream = new FileInputStream("/Users/denis/Downloads/test6.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Solution solution2 = (Solution) objectInputStream.readObject();


    }
}
