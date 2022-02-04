package com.javarush.task.pro.task10.task1008;

/* 
Зарплата
*/

public class Programmer {
    private int salary = 1000;

    public Programmer(int salary) {
        this.salary = salary;
    }

    public Programmer() {
    }

    public void setSalary(int salary) {
        this.salary = Math.max(salary, this.salary);
    }

    public int getSalary() {
        return salary;
    }
}
