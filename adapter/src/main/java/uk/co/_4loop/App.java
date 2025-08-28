package uk.co._4loop;

import uk.co._4loop.adapter.Bicycle;
import uk.co._4loop.adapter.Cyclist;
import uk.co._4loop.adapter.MotorbikeAdapter;

/**
 * Adapter Pattern Demonstration Application
 * 
 * The Adapter Pattern allows incompatible interfaces to work together by converting
 * the interface of a class into another interface that clients expect. This pattern
 * is useful when you need to use an existing class with an incompatible interface,
 * or when you want to create a reusable class that cooperates with classes that don't
 * necessarily have compatible interfaces.
 * 
 * Key Components demonstrated:
 * - Target: The interface that the client expects (Bicycle interface)
 * - Adaptee: The existing class with incompatible interface (Motorbike)
 * - Adapter: Converts the interface of Adaptee to Target interface (MotorbikeAdapter)
 * - Client: Works with objects conforming to Target interface (Cyclist)
 * 
 * This example demonstrates:
 * - A Cyclist can work with any object that implements the Bicycle interface
 * - MotorbikeAdapter adapts a Motorbike to work as a Bicycle
 * - The same client code (Cyclist) works with both real bicycles and adapted motorbikes
 */
public class App {

    /**
     * Program entry point - demonstrates Adapter Pattern with vehicle transportation.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        System.out.println("--- Adapter Pattern Demonstration ---");
        System.out.println("Making incompatible interfaces work together through adaptation.\n");

        // Direct usage of compatible interface - Cyclist expects Bicycle interface
        System.out.println("--- Using original Bicycle (Target) ---");
        var cyclist = new Cyclist(new Bicycle());
        cyclist.peddle(); // Direct call to compatible interface

        System.out.println("\n--- Using Motorbike through Adapter ---");
        // Using incompatible class through adapter - Motorbike adapted to Bicycle interface
        // The MotorbikeAdapter converts Motorbike's interface to match Bicycle interface
        var biker = new Cyclist(new MotorbikeAdapter());
        biker.peddle(); // Same method call, but adapter converts to motorbike operations

        System.out.println("\n--- Adapter Pattern Benefits Demonstrated ---");
        System.out.println("1. Client code (Cyclist) remains unchanged regardless of underlying implementation");
        System.out.println("2. Incompatible classes (Motorbike) can be used without modification");
        System.out.println("3. Promotes code reuse by making existing classes work in new contexts");
        System.out.println("4. Separates interface conversion logic from business logic");
    }
}
