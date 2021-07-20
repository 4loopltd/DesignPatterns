package _4loop.observer;

import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
@Slf4j
public class PriceObserver implements Observer {

    public void update(Observable obj, Object arg) {
        if (arg instanceof Float) {
            log.info("Price changed to " + arg);
        }
    }
}