package _4loop;

import _4loop.observer.ConcreteSubject;
import _4loop.observer.NameObserver;
import _4loop.observer.PriceObserver;
import _4loop.property.Company;
import _4loop.property.Exchange;
import lombok.extern.slf4j.Slf4j;

/**
 * Observer Pattern Demonstration Application
 * 
 * The Observer Pattern defines a one-to-many dependency between objects so that when
 * one object changes state, all its dependents are notified and updated automatically.
 * This pattern is useful for implementing distributed event handling systems and
 * maintaining consistency between related objects without tight coupling.
 * 
 * Key Components demonstrated:
 * - Subject: Interface for objects being observed (Observable in Java)
 * - ConcreteSubject: Maintains state and notifies observers when state changes (ConcreteSubject, Company)
 * - Observer: Interface for objects that should be notified (Observer, PropertyChangeListener)
 * - ConcreteObserver: Implements Observer interface and updates based on subject changes (NameObserver, PriceObserver, Exchange)
 * 
 * This example demonstrates:
 * - Stock price monitoring with multiple observers tracking different aspects
 * - Two different Observer implementations: Java Observable (legacy) and PropertyChangeSupport (modern)
 * - Automatic notification when subject state changes
 * - Loose coupling between subjects and observers
 */
@Slf4j
public class App {

    /**
     * Program entry point - demonstrates Observer Pattern with stock price monitoring.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        log.info("--- Observer Pattern Demonstration ---");
        log.info("Multiple observers monitoring stock price changes automatically.\n");

        log.info("--- Classic Observer Implementation (Java Observable - Legacy) ---");
        log.info("Note: Java Observable deprecated since JDK 9, but pattern remains valid.");

        // Subject that observers will watch
        ConcreteSubject subject = new ConcreteSubject("DAT", 19.14f);

        // Multiple observers interested in different aspects of the subject
        subject.addObserver(new NameObserver());      // Observer interested in name changes
        subject.addObserver(new PriceObserver());     // Observer interested in price changes

        log.info("Initial state");

        log.info("\n--- Triggering Notifications Through State Changes ---");
        log.info(">> Changing company name (triggers NameObserver):");
        subject.setName("Datsun");                    // Notifies all observers, NameObserver reacts

        log.info(">> Changing stock price (triggers PriceObserver):");
        subject.setPrice(19.31f);                     // Notifies all observers, PriceObserver reacts

        log.info(">> Another name change:");
        subject.setName("Nissan");                    // Again triggers notification to all observers

        log.info(">> Another price change:");
        subject.setPrice(19.81f);                     // Automatic notification and observer updates

        log.info("\n--- Modern Alternative: PropertyChangeSupport ---");
        log.info("Java's recommended approach for implementing Observer pattern.");

        // Modern implementation using PropertyChangeSupport
        Company observable = new Company(20.20f);    // Subject using PropertyChangeSupport
        Exchange observer = new Exchange();          // Observer using PropertyChangeListener interface

        log.info("Adding PropertyChangeListener observer...");
        observable.addListener(observer);            // Register observer with subject

        log.info(">> Triggering property change event:");
        observable.setPrice(20.21f);                 // Triggers PropertyChangeEvent notification

        log.info("\n--- Observer Pattern Mechanics ---");
        log.info("1. Observers register with Subject (addObserver/addListener)");
        log.info("2. Subject maintains list of registered observers");
        log.info("3. When Subject state changes, it notifies all observers");
        log.info("4. Each Observer receives notification and updates accordingly");
        log.info("5. Subject doesn't need to know what observers do with notifications");

        log.info("\n--- Observer Pattern Benefits Demonstrated ---");
        log.info("1. Loose coupling - Subject and Observer can vary independently");
        log.info("2. Dynamic relationships - observers can be added/removed at runtime");
        log.info("3. Broadcast communication - one change notifies multiple observers");
        log.info("4. Open/Closed Principle - can add new observers without modifying subject");
        log.info("5. Separation of concerns - observers handle their own update logic");
        log.info("6. Supports different observer types interested in different aspects");

    }

}