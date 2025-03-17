package com.main;

/**
 * The RallyCar class represents a generic rally car with attributes such as make, model, horsepower, and weight.
 * It provides methods to calculate the car's performance.
 *
 * @param make  The make of the car.
 * @param model The model of the car.
 * @param hp    The horsepower of the car.
 * @param weight The weight of the car.
 */
public abstract class RallyCar {
    private String make;
    private String model;
    private int horsepower;

    public RallyCar(String make, String model, int horsepower) {
        this.make = make;
        this.model = model;
        this.horsepower = horsepower;
    }

    public abstract double calculatePerformance();

    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getHorsepower() { return horsepower; }
}
