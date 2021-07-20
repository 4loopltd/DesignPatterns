package uk.co._4loop.adapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Motorbike implements MotorVehicle {

    @Override
    public void drive() {
        log.info("Your riding a motorbike");
    }

}
