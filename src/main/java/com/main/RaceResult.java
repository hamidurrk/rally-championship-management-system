package com.main;
import java.util.List;
import java.util.Map;

/**
 * The RaceResult interface defines the contract for classes that represent race results.
 * It includes methods for recording results, retrieving results, and getting ranked results.
 */
public interface RaceResult {
    /**
     * Records the result of a driver in a race.
     *
     * @param driver   The driver who participated in the race.
     * @param position The position the driver finished in the race.
     * @param points   The points awarded to the driver for their position.
     */
    void recordResult(Driver driver, int position, int points);
    
    /**
     * Retrieves the results of the race as a map of drivers and their points.
     *
     * @return A map where the key is the driver and the value is the points they earned.
     */
    Map<Driver, Integer> getResults();

        /**
     * Retrieves the ranked results of the race as a list of drivers.
     *
     * @return A list of drivers sorted by their performance in the race.
     */
    List<Driver> getRankedResults();
}
