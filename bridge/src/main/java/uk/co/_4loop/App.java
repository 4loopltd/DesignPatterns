package uk.co._4loop;

import uk.co._4loop.bridge.gearbox.AutomaticGearBox;
import uk.co._4loop.bridge.gearbox.GearBox;
import uk.co._4loop.bridge.gearbox.ManualGearBox;
import uk.co._4loop.bridge.vehicle.Car;
import uk.co._4loop.bridge.vehicle.Van;
import uk.co._4loop.bridge.vehicle.Vehicle;

/**
 * Bridge Pattern Demonstration Application
 * 
 * The Bridge Pattern decouples an abstraction from its implementation so that both
 * can vary independently. This pattern is useful when you want to share an implementation
 * among multiple objects, or when you want to switch implementations at runtime.
 * It promotes composition over inheritance and helps avoid permanent binding between
 * an abstraction and its implementation.
 * 
 * Key Components demonstrated:
 * - Abstraction: Defines the abstraction's interface and maintains reference to Implementor (Vehicle)
 * - RefinedAbstraction: Extends the interface defined by Abstraction (Car, Van)
 * - Implementor: Defines the interface for implementation classes (GearBox)
 * - ConcreteImplementor: Implements the Implementor interface (ManualGearBox, AutomaticGearBox)
 * 
 * This example demonstrates:
 * - Vehicles (abstraction) are decoupled from GearBox implementations
 * - Any Vehicle type can use any GearBox type
 * - Both hierarchies can evolve independently
 * - Runtime composition instead of compile-time inheritance
 */
public class App {

    /**
     * Program entry point - demonstrates Bridge Pattern with vehicles and gearboxes.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        System.out.println("--- Bridge Pattern Demonstration ---");
        System.out.println("The Abstraction (Vehicle) is decoupled from the Implementation (GearBox).");
        System.out.println("We can mix and match them independently.\n");

        // Create implementations - these can be reused across multiple abstractions
        GearBox manual = new ManualGearBox();      // ConcreteImplementor A
        GearBox automatic = new AutomaticGearBox(); // ConcreteImplementor B

        System.out.println("--- Testing Car (RefinedAbstraction) with different implementations ---");
        // Same abstraction (Car) using different implementations
        Vehicle manualCar = new Car(manual);        // Bridge: Car uses ManualGearBox
        manualCar.changeGear();                     // Delegates to manual implementation

        Vehicle automaticCar = new Car(automatic);  // Bridge: Car uses AutomaticGearBox  
        automaticCar.changeGear();                  // Delegates to automatic implementation

        System.out.println("\n--- Testing Van (RefinedAbstraction) with different implementations ---");
        // Different abstraction (Van) using same implementations
        Vehicle manualVan = new Van(manual);        // Bridge: Van uses ManualGearBox
        manualVan.changeGear();                     // Same implementation, different abstraction behavior

        Vehicle automaticVan = new Van(automatic);  // Bridge: Van uses AutomaticGearBox
        automaticVan.changeGear();                  // Both Van and Car can use any GearBox type

        System.out.println("\n--- Bridge Pattern Benefits Demonstrated ---");
        System.out.println("1. Abstraction and Implementation can vary independently");
        System.out.println("2. Implementation can be selected/changed at runtime");
        System.out.println("3. Both Vehicle types and GearBox types can be extended separately");
        System.out.println("4. Promotes composition over inheritance");
        System.out.println("5. Client code works with abstraction, unaware of implementation details");
    }
}
