package _4loop;

import _4loop.flyweight.CarFactory;
import _4loop.flyweight.car.Car;
import _4loop.flyweight.car.CarType;
import lombok.extern.slf4j.Slf4j;

/**
 * Flyweight Pattern Demonstration Application
 * 
 * The Flyweight Pattern uses sharing to support large numbers of fine-grained objects
 * efficiently. It minimizes memory usage by sharing efficiently all data that is
 * common to several objects. This pattern is useful when you need to create a large
 * number of objects that share common state, allowing you to reduce memory consumption.
 * 
 * Key Components demonstrated:
 * - Flyweight: Interface through which flyweights can receive and act on extrinsic state (Car)
 * - ConcreteFlyweight: Implements Flyweight and stores intrinsic state (CompactCar, SportsCar, etc.)
 * - FlyweightFactory: Creates and manages flyweight objects, ensures sharing (CarFactory)
 * - Context: Contains extrinsic state (color parameter passed to build method)
 * - Client: Maintains references to flyweights and computes extrinsic state (App)
 * 
 * This example demonstrates:
 * - Object sharing based on intrinsic state (car type/model)
 * - Extrinsic state passed as parameters (color) rather than stored in objects
 * - Memory efficiency through object reuse
 * - Factory controlling flyweight instantiation and sharing
 */
@Slf4j
public class App {

    /**
     * Program entry point - demonstrates Flyweight Pattern with car object sharing.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        log.info("--- Flyweight Pattern Demonstration ---");
        log.info("The goal is to reuse objects (Flyweights) by sharing their intrinsic state.\n");

        log.info("--- Understanding Intrinsic vs Extrinsic State ---");
        log.info("Intrinsic State: Car type/model specifications (shared among all instances)");
        log.info("Extrinsic State: Color, owner, location (varies per context/usage)\n");

        log.info(">> Requesting a COMPACT car for the first time...");
        // Factory creates new flyweight for COMPACT type
        Car compact = CarFactory.create(CarType.COMPACT);
        log.info("...received object with hash code: {}", compact.hashCode());
        compact.build("red"); // Extrinsic state (color) passed as parameter

        log.info("\n>> Requesting a FAMILY car for the first time...");
        // Factory creates new flyweight for FAMILY type  
        Car family = CarFactory.create(CarType.FAMILY);
        log.info("...received object with hash code: {}", family.hashCode());
        family.build("green"); // Different extrinsic state

        log.info("\n>> Requesting a SPORTS car for the first time...");
        // Factory creates new flyweight for SPORTS type
        Car sports = CarFactory.create(CarType.SPORTS);
        log.info("...received object with hash code: {}", sports.hashCode());
        sports.build("blue");

        log.info("\n>> Requesting a COMPACT car for the second time...");
        // Factory returns existing flyweight - SAME OBJECT as first compact request
        Car compact2 = CarFactory.create(CarType.COMPACT);
        log.info("...received object with hash code: {}. Note: It's the same object as the first compact car!", compact2.hashCode());
        compact2.build("green"); // Same flyweight, different extrinsic state (color)

        log.info("\n>> Requesting a COMPACT car for the third time...");
        // Factory returns same flyweight again - demonstrating sharing
        Car compact3 = CarFactory.create(CarType.COMPACT);
        log.info("...received object with hash code: {}. Still the same shared object!", compact3.hashCode());
        compact3.build("blue");

        log.info("\n--- Memory Usage Analysis ---");
        log.info("Traditional approach: 5 car requests = 5 objects in memory");
        log.info("Flyweight approach: 5 car requests = 3 objects in memory (COMPACT, FAMILY, SPORTS)");
        log.info("Memory saved: 40% in this small example, scales significantly with more objects");

        log.info("\n--- Flyweight Pattern Benefits Demonstrated ---");
        log.info("1. Dramatic memory savings through object sharing");
        log.info("2. Intrinsic state shared among multiple contexts");
        log.info("3. Extrinsic state passed as parameters, not stored in flyweights");
        log.info("4. Factory ensures proper sharing and prevents duplicate flyweights");
        log.info("5. Transparent to client - same interface whether shared or not");
        log.info("6. Most effective when dealing with large numbers of similar objects");

    }

}