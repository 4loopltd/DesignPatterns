package _4loop.facade.engine;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ignition {

    public void accessory() {
        log.info("Ignition set to accessory");
    }

    public void on() {
        log.info("Ignition set to on");
    }

    public void start() {
        log.info("Ignition set to start");
    }

    public void off() {
        log.info("Ignition set to off");
    }

    public void lock() {
        log.info("Ignition set to lock");
    }
}
