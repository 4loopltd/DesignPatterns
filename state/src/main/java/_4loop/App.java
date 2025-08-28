package _4loop;

import _4loop.state.Context;
import _4loop.state.RedState;
import lombok.extern.slf4j.Slf4j;

/**
 * State Pattern Demonstration Application
 * 
 * The State Pattern allows an object to alter its behavior when its internal state changes.
 * The object will appear to change its class. This pattern is useful when you have an object
 * that has many different states and the object's behavior changes significantly based on its state.
 * 
 * Key Components demonstrated:
 * - Context: Maintains a reference to a state object and delegates state-specific behavior to it
 * - State: Defines the interface for encapsulating behavior associated with a particular state
 * - ConcreteState: Implements behavior associated with a state of the Context
 * 
 * This example uses a traffic light system where:
 * - Context represents the traffic light controller
 * - States represent different light colors (Red, Green, Yellow)
 * - Each state knows how to transition to the next appropriate state
 * - The same method call (next()) produces different behaviors based on current state
 */
@Slf4j
public class App {

    /**
     * Program entry point - demonstrates State Pattern with traffic light transitions.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        log.info("--- State Pattern Demonstration ---");
        log.info("The object's behavior (Context) changes based on its internal state.\n");

        // Create Context with initial state - demonstrates dependency injection of state
        // Using RedState.getInstance() shows Singleton pattern integration
        Context trafficLight = new Context(RedState.getInstance());
        log.info("Initial State: {}", trafficLight.getState());

        // Each next() call delegates to the current state's next() method
        // The state object itself determines the next state transition
        log.info("Triggering next state...");
        trafficLight.next(); // Red -> Green
        log.info("Current State: {}", trafficLight.getState());

        log.info("Triggering next state...");
        trafficLight.next(); // Green -> Yellow
        log.info("Current State: {}", trafficLight.getState());

        log.info("Triggering next state...");
        trafficLight.next(); // Yellow -> Red
        log.info("Current State: {}", trafficLight.getState());

        // Demonstrates cyclical state transitions - back to Green
        log.info("Triggering next state...");
        trafficLight.next(); // Red -> Green (cycle continues)
        log.info("Current State: {}", trafficLight.getState());

        log.info("\n--- State Pattern Benefits Demonstrated ---");
        log.info("1. Context behavior changes automatically with state changes");
        log.info("2. State transitions are encapsulated within each state class");
        log.info("3. Adding new states requires minimal changes to existing code");
        log.info("4. Eliminates complex conditional statements for state management");

    }

}