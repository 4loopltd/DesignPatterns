package _4loop.factory.car;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SportsCar extends Car {

    public SportsCar() {
        super(CarType.SPORTS);
    }

    @Override
    public void build() {
        log.info("Building a " + getModel());
    }
}
