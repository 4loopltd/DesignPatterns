package _4loop.factory.car;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FamilyCar extends Car {

    public FamilyCar() {
        super(CarType.FAMILY);
    }

    @Override
    public void build() {
        log.info("Building a " + getModel());
    }
}
