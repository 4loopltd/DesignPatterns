package uk.co._4loop.bridge.vehicle;

import lombok.extern.slf4j.Slf4j;
import uk.co._4loop.bridge.gearbox.GearBox;

@Slf4j
public class Car extends Vehicle {

    public Car(GearBox gearBox) {
        super(gearBox);
    }

    @Override
    public void changeGear() {
        log.info("Car change gear: " + gearBox.handleGear());
    }
}
