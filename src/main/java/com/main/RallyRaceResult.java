package com.main;
import java.util.*;

/**
 * The RallyRaceResult class represents the results of a single rally race.
 * It stores the race name, location, and the results of drivers, including their positions and points.
 *
 * @param raceName The name of the rally race.
 * @param location The location of the rally race.
 */
public class RallyRaceResult implements RaceResult {
    private String raceName;
    private String location;
    private Map<Driver, Integer> results = new LinkedHashMap<>();

    /**
     * Constructor for the RallyRaceResult class.
     *
     * @param raceName The name of the rally race.
     * @param location The location of the rally race.
     */
    public RallyRaceResult(String raceName, String location) {
        this.raceName = raceName;
        this.location = location;
    }

    /**
     * Records the result of a driver in the race.
     *
     * @param driver   The driver who participated in the race.
     * @param position The position the driver finished in the race.
     * @param points   The points awarded to the driver for their position.
     */
    @Override
    public void recordResult(Driver driver, int position, int points) {
        results.put(driver, points);
        driver.addPoints(points);
    }

    /**
     * Gets the results
     *
     * @return The results of the race.
     */
    @Override
    public Map<Driver, Integer> getResults() {
        return Collections.unmodifiableMap(results);
    }

    /**
     * Gets the ranked results
     *
     * @return The ranked results of the race.
     */
    @Override
    public List<Driver> getRankedResults() {
        List<Driver> ranked = new ArrayList<>(results.keySet());
        ranked.sort((d1, d2) -> results.get(d2) - results.get(d1));
        return ranked;
    }

    // Getters for race name, location, and formatted results
    public String getRaceName() { return raceName; }
    public String getLocation() { return location; }
    public String getFormattedResults() {
        StringBuilder sb = new StringBuilder();
        sb.append("Race: ").append(raceName).append(" (").append(location).append(")\n");
        List<Map.Entry<Driver, Integer>> sortedResults = new ArrayList<>(results.entrySet());
        sortedResults.sort((e1, e2) -> e2.getValue() - e1.getValue()); // Sort by points descending
        int position = 1;
        for (Map.Entry<Driver, Integer> entry : sortedResults) {
            sb.append(" Position ").append(position).append(": ")
              .append(entry.getKey().getName()).append(" - ")
              .append(entry.getValue()).append(" points\n");
            position++;
        }
        return sb.toString();
    }
}