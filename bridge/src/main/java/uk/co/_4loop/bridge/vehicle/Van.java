package uk.co._4loop.bridge.vehicle;

import lombok.extern.slf4j.Slf4j;
import uk.co._4loop.bridge.gearbox.GearBox;

@Slf4j
public class Van extends Vehicle {

    public Van(GearBox gearBox) {
        super(gearBox);
    }

    @Override
    public void changeGear() {
        log.info("Van change gear: " + gearBox.handleGear());
    }
}