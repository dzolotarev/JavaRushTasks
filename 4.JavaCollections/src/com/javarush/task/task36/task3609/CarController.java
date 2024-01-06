package com.javarush.task.task36.task3609;

public class CarController {
    private CarModel model;
    private SpeedometerView view;

    public CarController(CarModel model, SpeedometerView view) {
        this.model = model;
        this.view = view;
    }

    public String getCarBrand() {
        return model.getBrand();
    }

    public String getCarModel() {
        return model.getModel();
    }

    public void setCarSpeed(int speed) {
        model.setSpeed(speed);
    }

    public int getCarSpeed() {
        return model.getSpeed();
    }

    public int getCarMaxSpeed() {
        return model.getMaxSpeed();
    }

    public void updateView() {
        view.printCarDetails(getCarBrand(), getCarModel(), getCarSpeed());
    }

    public void increaseSpeed(int seconds) {
        int speed;
        int maxSpeed = getCarMaxSpeed();
        if ((speed = getCarSpeed()) < maxSpeed) {
            setCarSpeed((int) (speed + (3.5 * seconds)));
        }
        if (getCarSpeed() > maxSpeed) {
            setCarSpeed(maxSpeed);
        }
    }

    public void decreaseSpeed(int seconds) {
        int speed;
        if ((speed = getCarSpeed()) > 0) {
            setCarSpeed(speed - (12 * seconds));
        }
        if (getCarSpeed() < 0) {
            setCarSpeed(0);
        }
    }
}