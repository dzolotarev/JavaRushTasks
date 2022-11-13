package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0)
            throw new Exception();
        fuel += numberOfLiters;
    }

    public static Car create(int type, int numberOfPassengers) {
        Car car = null;
        switch (type) {
            case TRUCK:
                car = new Truck(numberOfPassengers);
                break;
            case SEDAN:
                car = new Sedan(numberOfPassengers);
                break;
            case CABRIOLET:
                car = new Cabriolet(numberOfPassengers);
                break;
        }
        return car;
    }

    public boolean isSummer(Date date, Date summerStart, Date summerEnd) {
        if (date.before(summerStart) || date.after(summerEnd)) return false;
        return true;
    }

    public double getWinterConsumption(int length) {
        double consumption;
        return consumption = length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {
        double consumption;
        return consumption = length * summerFuelConsumption;
    }


    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        return isSummer(date, SummerStart, SummerEnd) ? getSummerConsumption(length) : getWinterConsumption(length);
    }

    private boolean canPassengersBeTransferred(){
        return (fuel>0) && isDriverAvailable();
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if(!canPassengersBeTransferred()) return 0;
        return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
        fastenDriverBelt();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();
}