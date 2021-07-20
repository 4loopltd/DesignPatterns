package uk.co._4loop.callback;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class SimpleTask extends Task {

    @Override
    public void execute() {
        log.info("Performing simple task.");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
