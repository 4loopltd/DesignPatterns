package _4loop.factory.car;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompactCar extends Car {

    public CompactCar() {
        super(CarType.COMPACT);
    }

    @Override
    public void build() {
        log.info("Building a " + getModel());
    }


}
