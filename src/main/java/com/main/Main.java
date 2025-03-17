package com.main;

/**
 * The Main class serves as the entry point for the Rally Championship Management System.
 * It initializes the championship, registers drivers, simulates races, and displays results.
 */
public class Main {
    public static void main(String[] args) {
        ChampionshipManager manager = ChampionshipManager.getInstance();

        // Create cars
        RallyCar gravelCar1 = new GravelCar("Subaru", "Impreza", 250, 18);  
        RallyCar asphaltCar1 = new AsphaltCar("Ford", "Fiesta", 310, 17);    
        RallyCar gravelCar2 = new GravelCar("Mitsubishi", "Lancer", 300, 18);  
        RallyCar asphaltCar2 = new AsphaltCar("Citroen", "C3", 290, 16);    

        // Create drivers
        Driver ogier = new Driver("Sébastien Ogier", "France", gravelCar1);
        Driver rovanpera = new Driver("Kalle Rovanperä", "Finland", asphaltCar1);
        Driver tanak = new Driver("Ott Tänak", "Estonia", gravelCar2);
        Driver neuville = new Driver("Thierry Neuville", "Belgium", asphaltCar2);
        
        // Register drivers
        manager.registerDriver(ogier);
        manager.registerDriver(rovanpera);
        manager.registerDriver(tanak);
        manager.registerDriver(neuville);

        // Simulate races
        RallyRaceResult finland = new RallyRaceResult("Rally Finland", "Jyväskylä");
        finland.recordResult(ogier, 1, 25);
        finland.recordResult(tanak, 2, 18);
        finland.recordResult(rovanpera, 3, 15);
        finland.recordResult(neuville, 4, 12);
        manager.addRaceResult(finland);

        // Change cars
        ogier.setCar(new AsphaltCar("Toyota", "GR Yaris", 265, 17));
        RallyRaceResult monaco = new RallyRaceResult("Monte Carlo Rally", "Monaco");
        monaco.recordResult(rovanpera, 1, 25);
        monaco.recordResult(neuville, 2, 18);
        monaco.recordResult(ogier, 3, 15);
        monaco.recordResult(tanak, 4, 12);
        manager.addRaceResult(monaco);

        System.out.println("===== CHAMPIONSHIP STANDINGS =====");
        manager.getDriverStandings().forEach(d -> 
            System.out.printf("%s (%s): %d points%n", 
            d.getName(), d.getCountry(), d.getPoints()));

        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
            System.out.println(manager.getLeadingDriver().getName() + " with " + manager.getLeadingDriver().getPoints() + " points");

        System.out.println("\n===== STATISTICS =====");
        System.out.println("Total Drivers: " + ChampionshipManager.getTotalDrivers());
        System.out.println("Total Races: " + ChampionshipManager.getTotalRaces());
        System.out.printf("Average Points: %.2f%n", 
            ChampionshipStatistics.calculateAveragePoints(manager.getDriverStandings()));
        System.out.println("Most Successful Country: " + 
            ChampionshipStatistics.findMostSuccessfulCountry(manager.getDriverStandings()));
        System.out.println("Total Points: " + ChampionshipManager.getTotalChampionshipPoints());

        System.out.println("\n===== RACE RESULTS =====");
        manager.getRaces().forEach(race -> System.out.println(race.getFormattedResults()));

        System.out.println("\n===== CAR PERFORMANCE =====");
        System.out.printf("Gravel Car: %.1f%n", tanak.getCar().calculatePerformance());
        System.out.printf("Asphalt Car: %.1f%n", rovanpera.getCar().calculatePerformance());
    }
}