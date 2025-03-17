package com.main;

/**
 * The Driver class represents a rally driver with attributes such as name, country, and the car they drive.
 * It tracks the driver's points and provides methods to update their car and points.
 *
 * @param name    The name of the driver.
 * @param country The country of the driver.
 * @param car     The car driven by the driver.
 */
public class Driver {
    private String name;
    private String country;
    private int points;
    private RallyCar car;

    public Driver(String name, String country, RallyCar car) {
        this.name = name;
        this.country = country;
        this.car = car;
        this.points = 0;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public String getName() { return name; }
    public String getCountry() { return country; }
    public int getPoints() { return points; }
    public RallyCar getCar() { return car; }
    public void setCar(RallyCar car) { this.car = car; }
}