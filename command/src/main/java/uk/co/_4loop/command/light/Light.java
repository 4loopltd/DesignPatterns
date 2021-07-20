package uk.co._4loop.command.light;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Light {
    public void turnOn() {
        log.info("Light is on");
    }

    public void turnOff() {
        log.info("Light is off");
    }
}