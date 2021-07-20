package _4loop.observer;

import lombok.extern.slf4j.Slf4j;

import java.util.Observable;

@SuppressWarnings("deprecation")
@Slf4j
public class ConcreteSubject extends Observable {

    public ConcreteSubject(String name, float price) {
        log.info("Created, Name: " + name + " Price: " + price);
    }

    public void setName(String name) {
        setChanged();
        notifyObservers(name);
    }

    public void setPrice(float price) {
        setChanged();
        notifyObservers(price);
    }

}
