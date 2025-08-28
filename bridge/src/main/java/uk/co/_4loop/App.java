package uk.co._4loop;

import uk.co._4loop.bridge.gearbox.AutomaticGearBox;
import uk.co._4loop.bridge.gearbox.GearBox;
import uk.co._4loop.bridge.gearbox.ManualGearBox;
import uk.co._4loop.bridge.vehicle.Car;
import uk.co._4loop.bridge.vehicle.Van;
import uk.co._4loop.bridge.vehicle.Vehicle;

public class App {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        System.out.println("--- Demonstrating the Bridge Pattern ---");
        System.out.println("The Abstraction (Vehicle) is decoupled from the Implementation (GearBox).");
        System.out.println("We can mix and match them independently.\n");

        GearBox manual = new ManualGearBox();
        GearBox automatic = new AutomaticGearBox();

        System.out.println("--- Testing a Car (Refined Abstraction) ---");
        Vehicle manualCar = new Car(manual);
        manualCar.changeGear();

        Vehicle automaticCar = new Car(automatic);
        automaticCar.changeGear();

        System.out.println("\n--- Testing a Van (Refined Abstraction) ---");
        Vehicle manualVan = new Van(manual);
        manualVan.changeGear();

        Vehicle automaticVan = new Van(automatic);
        automaticVan.changeGear();
    }
}
