package com.main;

/**
 * The AsphaltCar class extends RallyCar and represents a car optimized for asphalt surfaces.
 * It overrides performance calculations specific to asphalt terrain.
 *
 * @param make  The make of the car.
 * @param model The model of the car.
 * @param horsepower The horsepower of the car.
 * @param downforce The downforce of the car.
 */
public class AsphaltCar extends RallyCar {
    private double downforce;

    public AsphaltCar(String make, String model, int horsepower, double downforce) {
        super(make, model, horsepower);
        this.downforce = downforce;
    }

    /**
     * Calculates the performance of the car on asphalt terrain.
     *
     * @return The performance value of the car.
     */
    @Override
    public double calculatePerformance() {
        return getHorsepower() * 1.1 + (downforce * 8);
    }

    public double getDownforce() { return downforce; }
}

