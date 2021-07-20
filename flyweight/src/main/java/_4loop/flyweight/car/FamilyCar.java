package _4loop.flyweight.car;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FamilyCar extends Car {

    public FamilyCar() {
        super(CarType.FAMILY);
    }

    @Override
    public void build(String colour) {
        log.info("Building a " + colour + " " + getModel());
    }
}
