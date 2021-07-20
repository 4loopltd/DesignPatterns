package _4loop.flyweight.car;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SportsCar extends Car {

    public SportsCar() {
        super(CarType.SPORTS);
    }

    @Override
    public void build(String colour) {
        log.info("Building a " + colour + " " + getModel());
    }
}
