package _4loop.property;

import lombok.extern.slf4j.Slf4j;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

@Slf4j
public class Company {

    private float price;

    private final PropertyChangeSupport support;

    public Company(float price) {
        this.price = price;

        support = new PropertyChangeSupport(this);

        log.info("Created, Price: " + price);
    }

    public void addListener(Exchange observer) {
        support.addPropertyChangeListener(observer);
    }

    public void removeListener(PropertyChangeListener observer) {
        support.removePropertyChangeListener(observer);
    }

    public void setPrice(float value) {
        support.firePropertyChange("Price", price, value);

        price = value;
    }
}
