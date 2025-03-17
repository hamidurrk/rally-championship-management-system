package com.main;

/**
 * The GravelCar class extends RallyCar and represents a car optimized for gravel surfaces.
 * It overrides performance calculations specific to gravel terrain.
 *
 * @param make  The make of the car.
 * @param model The model of the car.
 * @param horsepower The horsepower of the car.
 * @param suspensionTravel The suspension travel of the car.
 */
public class GravelCar extends RallyCar {
    private double suspensionTravel;

    public GravelCar(String make, String model, int horsepower, double suspensionTravel) {
        super(make, model, horsepower);
        this.suspensionTravel = suspensionTravel;
    }

    /**
     * Calculates the performance of the car on gravel terrain.
     *
     * @return The performance value of the car.
     */
    @Override
    public double calculatePerformance() {
        return getHorsepower() * 0.8 + (suspensionTravel * 10);
    }

    public double getSuspensionTravel() { return suspensionTravel; }
}

