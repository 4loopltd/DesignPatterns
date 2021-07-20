package _4loop;

import _4loop.observer.ConcreteSubject;
import _4loop.observer.NameObserver;
import _4loop.observer.PriceObserver;
import _4loop.property.Company;
import _4loop.property.Exchange;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        // Java Observable - deprecated since 9.
        // Which doesnt mean the pattern itself is fatally flawed.
        ConcreteSubject subject = new ConcreteSubject("DAT", 19.14f);
        subject.addObserver(new NameObserver());
        subject.addObserver(new PriceObserver());

        subject.setName("Datsun");
        subject.setPrice(19.31f);
        subject.setName("Nissan");
        subject.setPrice(19.81f);

        // PropertyChangeSupport - One of many alternatives to Observable
        Company observable = new Company(20.20f);
        Exchange observer = new Exchange();

        observable.addListener(observer);
        observable.setPrice(20.21f);

    }

}