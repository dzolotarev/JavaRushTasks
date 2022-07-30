package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    static Hippodrome game;

    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse winnerHorse = null;
        double maxDistance = 0;
        for (Horse horse : horses) {
            if(horse.getDistance()>maxDistance){
                maxDistance = horse.getDistance();
                winnerHorse = horse;
            }
        }
        return winnerHorse;
    }

    public void printWinner() {
        System.out.printf("Winner is %s!\n", getWinner().getName());
    }

    public static void main(String[] args) throws InterruptedException {

        List<Horse> myHorses = new ArrayList<>();
        game = new Hippodrome(myHorses);
        Horse horse1 = new Horse("Homer", 3, 0);
        Horse horse2 = new Horse("Lucky", 3, 0);
        Horse horse3 = new Horse("Slevin", 3, 0);

        game.horses.add(horse1);
        game.horses.add(horse2);
        game.horses.add(horse3);
        game.run();
        game.printWinner();
    }
}
