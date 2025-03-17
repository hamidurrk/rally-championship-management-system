package com.main;
import java.util.*;

/**
 * The ChampionshipStatistics class provides utility methods to calculate statistics
 * such as average points, the most successful country, and other championship-related metrics.
 */
public class ChampionshipStatistics {
    /**
     * Calculates the average points of all drivers in the championship.
     *
     * @param drivers The list of drivers in the championship.
     * @return The average points of all drivers.
     */
    public static double calculateAveragePoints(List<Driver> drivers) {
        return drivers.stream()
            .mapToInt(Driver::getPoints)
            .average()
            .orElse(0.0);
    }

    /**
     * Finds the country with the most successful drivers in the championship.
     *
     * @param drivers The list of drivers in the championship.
     * @return The country with the most successful drivers.
     */
    public static String findMostSuccessfulCountry(List<Driver> drivers) {
        Map<String, Integer> countryPoints = new HashMap<>();
        drivers.forEach(d -> countryPoints.merge(d.getCountry(), d.getPoints(), Integer::sum));
        return Collections.max(countryPoints.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    /**
     * Calculates the total number of drivers registered in the championship.
     *
     * @return The total number of drivers registered.
     */
    public static int getTotalRacesHeld() {
        return ChampionshipManager.getTotalRaces();
    }
}