package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

/**
 * @author Denis Zolotarev
 */
public class FemaleFactory implements AbstractFactory {
    public Human getPerson(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Возраст не может меньше и равным нулю");
        } else if (age <= KidGirl.MAX_AGE) {
            return new KidGirl();
        } else if (age <= TeenGirl.MAX_AGE) {
            return new TeenGirl();
        } else
            return new Woman();
    }
}
