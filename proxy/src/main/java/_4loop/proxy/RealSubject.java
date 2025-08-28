package _4loop.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealSubject implements Subject {

    public RealSubject() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            log.error("Construction sleep interrupted", e);
            Thread.currentThread().interrupt(); // Preserve the interrupted status
        }
    }

    @Override
    public void process() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            log.error("Process sleep interrupted", e);
            Thread.currentThread().interrupt(); // Preserve the interrupted status
        }
    }

}
