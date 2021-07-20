package uk.co._4loop.command.fan;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Fan {
    public void startRotate() {
        log.info("Fan is rotating");
    }

    public void stopRotate() {
        log.info("Fan has stopped");
    }
}
