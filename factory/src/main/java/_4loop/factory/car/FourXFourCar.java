package _4loop.factory.car;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FourXFourCar extends Car {

    public FourXFourCar() {
        super(CarType.FOUR_X_FOUR);
    }

    @Override
    public void build() {
        log.info("Building a " + getModel());
    }
}
