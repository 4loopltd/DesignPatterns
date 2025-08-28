package _4loop;

import _4loop.template.FamilyCarBuilder;
import _4loop.template.SportsCarBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * Template Method Pattern Demonstration Application
 * 
 * The Template Method Pattern defines the skeleton of an algorithm in a base class,
 * letting subclasses override specific steps of the algorithm without changing
 * its structure. This pattern is useful when you have multiple classes that
 * implement similar algorithms with slight variations in some steps.
 * 
 * Key Components demonstrated:
 * - AbstractClass: Defines template method and declares abstract operations (CarBuilder)
 * - ConcreteClass: Implements abstract operations to carry out subclass-specific steps
 *   (SportsCarBuilder, FamilyCarBuilder)
 * - Template Method: Defines algorithm structure and calls primitive operations (buildCar)
 * - Primitive Operations: Steps of algorithm that subclasses implement (abstract methods)
 * 
 * This example demonstrates:
 * - Common car building process with different implementations for different car types
 * - Algorithm structure preserved while allowing customization of specific steps
 * - Code reuse through inheritance and template method
 * - Inversion of Control - base class controls algorithm flow, subclasses provide details
 */
@Slf4j
public class App {

    /**
     * Program entry point - demonstrates Template Method Pattern with car manufacturing.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        log.info("--- Template Method Pattern Demonstration ---");
        log.info("Same car building algorithm, different implementations for each car type.\n");

        log.info("--- Building Sports Car ---");
        log.info(">> Using SportsCarBuilder with sports-specific implementations:");
        // Template method (buildCar) defines the algorithm structure
        // SportsCarBuilder provides sports car-specific implementations of each step
        new SportsCarBuilder()
                .buildCar()                    // Template method - same algorithm structure
                .getCarParts()                 // Returns car parts specific to sports car
                .forEach(part -> log.info("Sports Car Part: {}", part));

        log.info("\n--- Building Family Car ---");
        log.info(">> Using FamilyCarBuilder with family-specific implementations:");
        // Same template method, different concrete implementations
        // FamilyCarBuilder provides family car-specific implementations of each step
        new FamilyCarBuilder()
                .buildCar()                    // Same template method structure
                .getCarParts()                 // Returns car parts specific to family car  
                .forEach(part -> log.info("Family Car Part: {}", part));

        log.info("\n--- Template Method Algorithm Flow ---");
        log.info("1. buildCar() template method defines the overall process");
        log.info("2. Each step in the template calls abstract methods");
        log.info("3. Subclasses provide concrete implementations for each abstract method");
        log.info("4. Algorithm structure remains consistent across all car types");
        log.info("5. Variations are handled through method overrides, not structural changes");

        log.info("\n--- Comparing Results ---");
        log.info("Both car types follow the same building process but produce different results:");

        var sportsCarParts = new SportsCarBuilder().buildCar().getCarParts();
        var familyCarParts = new FamilyCarBuilder().buildCar().getCarParts();

        log.info("Sports Car has {} parts: {}", sportsCarParts.size(), sportsCarParts);
        log.info("Family Car has {} parts: {}", familyCarParts.size(), familyCarParts);

        log.info("\n--- Template Method Pattern Benefits Demonstrated ---");
        log.info("1. Code reuse - common algorithm structure shared across subclasses");
        log.info("2. Consistent algorithm flow - all subclasses follow same process");
        log.info("3. Flexibility - subclasses customize behavior without changing structure");
        log.info("4. Inversion of Control - base class controls flow, subclasses provide details");
        log.info("5. Easy to add new car types - just implement abstract methods");
        log.info("6. DRY Principle - Don't Repeat Yourself in algorithm implementation");

    }

}