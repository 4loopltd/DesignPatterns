package _4loop.facade.engine;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FuelInjector {
    public void open() {
        log.info("Open fuel injector");
    }

    public void close() {
        log.info("Close fuel injector");
    }
}
