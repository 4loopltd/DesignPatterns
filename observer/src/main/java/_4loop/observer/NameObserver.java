package _4loop.observer;

import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
@Slf4j
public class NameObserver implements Observer {

    public void update(Observable obj, Object arg) {
        if (arg instanceof String) {
            log.info("Name changed to " + arg);
        }
    }
}
