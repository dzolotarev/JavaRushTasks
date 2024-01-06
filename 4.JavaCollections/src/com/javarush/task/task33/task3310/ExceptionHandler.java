package com.javarush.task.task33.task3310;

import static com.javarush.task.task33.task3310.Helper.printMessage;

/**
 * @author Denis Zolotarev
 */
public class ExceptionHandler extends Exception {
    public static void log(Exception e) {
        printMessage(e.getMessage());
    }
}
