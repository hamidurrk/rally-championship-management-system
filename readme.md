# Rally Championship Management System 
 **_(Week 9 - OOP Exercise | Object-Oriented Programming Course | Software and Systems Engineering - LUT University)_** 

This repository demonstrates a rally championship management system built with Java. It includes classes for drivers, cars, races, and a central manager to handle registrations and results.

## Project Structure

`com/main` package `has the following `.java` files:

1. `Main.java` - Entry point for the Rally Championship Management System.
2. `ChampionshipManager.java` - Manages drivers, races, and championship statistics.
3. `ChampionshipStatistics.java` - Provides utility methods for calculating championship statistics.
4. `RallyRaceResult.java` - Represents the results of a single rally race.
5. `RaceResult.java` - Interface defining methods for race result management.
6. `RallyCar.java` - Abstract class representing a generic rally car.
7. `AsphaltCar.java` - Represents a car optimized for asphalt surfaces.
8. `GravelCar.java` - Represents a car optimized for gravel surfaces.
9. `Driver.java` - Represents a rally driver with attributes like name, country, and car.

## Usage

1. Compile the project.
2. Run the `Main` class to see the championship workflow.

## Evaluation Criteria

### 1. Correct Implementation of Classes and Interfaces
All required classes and interfaces are properly defined (e.g., `Driver`, `ChampionshipManager`) and used to handle driver registration, race simulation, and result management.

### 2. OOP Concepts and SOLID Principles
- **Single Responsibility**: Classes handle distinct responsibilities (e.g., `Driver` manages driver details, `RallyRaceResult` manages race data).  
- **Open/Closed**: Classes can be extended without altering existing code.  
- **Liskov Substitution**: Subtypes like `GravelCar` and `AsphaltCar` inherit from `RallyCar` and behave as expected.  
- **Interface Segregation**: Interfaces contain the necessary methods, promoting minimal dependencies.  
- **Dependency Inversion**: Higher-level modules depend on abstractions (e.g., manager depends on interface-like structures).

### 3. Effective Use of Static Members/Methods
The `ChampionshipManager` uses relevant static methods or members where necessary to handle global state or instances.

### 4. Singleton Pattern
`ChampionshipManager` implements the Singleton pattern to ensure there is only one active manager for the entire application.

