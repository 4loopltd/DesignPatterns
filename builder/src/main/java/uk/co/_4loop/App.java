package uk.co._4loop;

import lombok.extern.slf4j.Slf4j;
import uk.co._4loop.builder.Vehicle;
import uk.co._4loop.builder.VehicleBuilder;
import uk.co._4loop.builder.parts.BodyColour;
import uk.co._4loop.builder.parts.EngineType;
import uk.co._4loop.builder.parts.Gearbox;
import uk.co._4loop.builder.parts.Wheels;

/**
 * Builder Pattern Demonstration Application
 * 
 * The Builder Pattern separates the construction of complex objects from their representation,
 * allowing the same construction process to create different representations. This pattern is
 * particularly useful when creating objects with many optional parameters or when the construction
 * process is complex and needs to be controlled step by step.
 * 
 * Key Components demonstrated:
 * - Product: The complex object being built (Vehicle)
 * - Builder: Interface/class that specifies methods for creating parts of Product (VehicleBuilder)
 * - ConcreteBuilder: Implements Builder and constructs/assembles parts of Product
 * - Director: Optional class that constructs objects using Builder interface
 * 
 * This example demonstrates:
 * - Fluent interface for readable object construction
 * - Step-by-step construction with method chaining
 * - Same builder creating different vehicle types with different configurations
 * - Separation of construction logic from the final product
 */
@Slf4j
public class App {

    /**
     * Program entry point - demonstrates Builder Pattern with vehicle construction.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        log.info("--- Builder Pattern Demonstration ---");
        log.info("Constructing complex objects step by step with different configurations.\n");

        // Building a Car - demonstrates fluent interface and method chaining
        log.info("--- Building an Electric Car ---");
        Vehicle car = new VehicleBuilder("car")
                .setWheels(Wheels.FOUR)        // Step-by-step construction
                .setEngineType(EngineType.ELECTRIC)  // Each method returns builder for chaining
                .setGearbox(Gearbox.AUTOMATIC)       // Fluent interface improves readability
                .setBodyColour(BodyColour.GREEN)
                .build();                      // Final step creates the Product
        log.info("Constructed: {}", car.toString());

        // Building a Motorbike - same builder, different configuration
        log.info("\n--- Building a Petrol Motorbike ---");
        Vehicle motorbike = new VehicleBuilder("motorbike")
                .setWheels(Wheels.TWO)
                .setEngineType(EngineType.PETROL)
                .setGearbox(Gearbox.MANUAL)
                .setBodyColour(BodyColour.RED)
                .build();
        log.info("Constructed: {}", motorbike.toString());

        // Building a Three-Wheeler - demonstrates flexibility of the builder
        log.info("\n--- Building a Diesel Robin (3-wheeler) ---");
        Vehicle van = new VehicleBuilder("robin")
                .setWheels(Wheels.THREE)
                .setEngineType(EngineType.DIESEL)
                .setGearbox(Gearbox.MANUAL)
                .setBodyColour(BodyColour.YELLOW)
                .build();
        log.info("Constructed: {}", van.toString());

        log.info("\n--- Builder Pattern Benefits Demonstrated ---");
        log.info("1. Readable object construction through fluent interface");
        log.info("2. Step-by-step construction allows validation at each step");
        log.info("3. Same construction process creates different object configurations");
        log.info("4. Immutable products can be created (if builder doesn't expose setters)");
        log.info("5. Complex construction logic is encapsulated in the builder");

    }
}
