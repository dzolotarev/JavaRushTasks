package com.javarush.task.task29.task2912;

import javax.swing.*;

public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        super(level);
    }
    public void info(String message) {
        System.out.println("Logging to console: " + message);
    }
}