package uk.co._4loop.adapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Bicycle implements Bike {

    @Override
    public void peddle() {
        log.info("Your riding a bike");
    }

}
