package _4loop.facade.engine;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AirIntake {
    public void open() {
        log.info("Open air intake");
    }

    public void close() {
        log.info("Close air intake");
    }
}
