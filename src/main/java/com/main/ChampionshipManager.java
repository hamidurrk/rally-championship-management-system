package com.main;
import java.util.*;

/**
 * The ChampionshipManager class is responsible for managing the championship.
 * It handles driver registration, race results, and provides statistics about the championship.
 */
public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers = new ArrayList<>();
    private List<RallyRaceResult> races = new ArrayList<>();
    private static int totalDrivers = 0;
    private static int totalRaces = 0;

    private ChampionshipManager() {}

    public static synchronized ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    /**
     * Registers a driver in the championship.
     *
     * @param driver The driver to register.
     */
    public void registerDriver(Driver driver) {
        drivers.add(driver);
        totalDrivers++;
    }

    /**
     * Adds a race result to the championship.
     *
     * @param result The race result to add.
     */
    public void addRaceResult(RallyRaceResult result) {
        races.add(result);
        totalRaces++;
    }

    // Getters for championship statistics
    
    public List<Driver> getDriverStandings() {
        drivers.sort((d1, d2) -> d2.getPoints() - d1.getPoints());
        return Collections.unmodifiableList(drivers);
    }

    public Driver getLeadingDriver() {
        return getDriverStandings().get(0);
    }

    public static int getTotalChampionshipPoints() {
        return instance.drivers.stream().mapToInt(Driver::getPoints).sum();
    }

    public static int getTotalDrivers() { return totalDrivers; }
    public static int getTotalRaces() { return totalRaces; }
    public List<RallyRaceResult> getRaces() { return races; }
}