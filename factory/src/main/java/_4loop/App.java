package _4loop;

import _4loop.factory.CarFactory;
import _4loop.factory.car.Car;
import _4loop.factory.car.CarType;
import lombok.extern.slf4j.Slf4j;

/**
 * Factory Method Pattern Demonstration Application
 * 
 * The Factory Method Pattern defines an interface for creating an object, but lets
 * subclasses decide which class to instantiate. This pattern lets a class defer
 * instantiation to subclasses. It's useful when you need to delegate the object
 * creation process to subclasses or when the exact types and dependencies of
 * objects aren't known until runtime.
 * 
 * Key Components demonstrated:
 * - Product: Interface for objects the factory method creates (Car)
 * - ConcreteProduct: Implements Product interface (CompactCar, FamilyCar, etc.)
 * - Creator: Declares factory method returning Product object (CarFactory)
 * - ConcreteCreator: Overrides factory method to return ConcreteProduct instance
 * 
 * This example demonstrates:
 * - Object creation based on type parameters
 * - Encapsulation of object creation logic
 * - Elimination of direct constructor calls in client code
 * - Centralized creation logic for easier maintenance
 */
@Slf4j
public class App {

    /**
     * Program entry point - demonstrates Factory Method Pattern with car manufacturing.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        log.info("--- Factory Method Pattern Demonstration ---");
        log.info("Creating different car types through factory method - client doesn't use constructors directly.\n");

        log.info("--- Manufacturing Different Car Types ---");

        log.info(">> Creating a Compact Car");
        // Factory method creates appropriate concrete product based on type
        // Client doesn't need to know about CompactCar class or its constructor
        Car compact = CarFactory.create(CarType.COMPACT);
        log.info("Factory produced: {}", compact.getClass().getSimpleName());
        log.info("Car details: {}", compact.toString());
        compact.build(); // Polymorphic behavior - each car type builds differently

        log.info("\n>> Creating a Family Car");
        Car family = CarFactory.create(CarType.FAMILY);
        log.info("Factory produced: {}", family.getClass().getSimpleName());
        log.info("Car details: {}", family.toString());
        family.build();

        log.info("\n>> Creating a 4x4 Off-Road Vehicle");
        Car fourByFour = CarFactory.create(CarType.FOUR_X_FOUR);
        log.info("Factory produced: {}", fourByFour.getClass().getSimpleName());
        log.info("Car details: {}", fourByFour.toString());
        fourByFour.build();

        log.info("\n>> Creating a Sports Car");
        Car sports = CarFactory.create(CarType.SPORTS);
        log.info("Factory produced: {}", sports.getClass().getSimpleName());
        log.info("Car details: {}", sports.toString());
        sports.build();

        log.info("\n--- Factory Method Pattern Benefits Demonstrated ---");
        log.info("1. Eliminates need for client to know concrete classes");
        log.info("2. Centralizes object creation logic in one place");
        log.info("3. Makes code more flexible - easy to add new car types");
        log.info("4. Follows Open/Closed Principle - open for extension, closed for modification");
        log.info("5. Reduces coupling between client code and concrete product classes");
        log.info("6. Provides consistent interface for object creation");

    }

}