package _4loop.flyweight.car;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompactCar extends Car {

    public CompactCar() {
        super(CarType.COMPACT);
    }

    @Override
    public void build(String colour) {
        log.info("Building a " + colour + " " + getModel());
    }


}
