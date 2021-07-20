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

        GearBox manual = new ManualGearBox();
        GearBox automatic = new AutomaticGearBox();

        Vehicle manualCar = new Car(manual);
        manualCar.changeGear();

        Vehicle automaticCar = new Car(automatic);
        automaticCar.changeGear();

        Vehicle manualVan = new Van(manual);
        manualVan.changeGear();

        Vehicle automaticVan = new Van(automatic);
        automaticVan.changeGear();
    }
}
