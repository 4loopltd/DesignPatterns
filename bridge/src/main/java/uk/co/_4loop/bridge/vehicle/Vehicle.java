package uk.co._4loop.bridge.vehicle;

import uk.co._4loop.bridge.gearbox.GearBox;

public abstract class Vehicle {
    final GearBox gearBox;

    public Vehicle(GearBox gearBox) {
        this.gearBox = gearBox;
    }

    public abstract void changeGear();
}
