package _4loop.property;

import lombok.extern.slf4j.Slf4j;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@Slf4j
public class Exchange implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        log.info(evt.getPropertyName() + " change: " + evt.getNewValue());
    }
}
