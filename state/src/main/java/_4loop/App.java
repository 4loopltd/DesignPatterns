package _4loop;

import _4loop.state.Context;
import _4loop.state.RedState;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        log.info("--- State Pattern Demonstration ---");
        log.info("The object's behavior (Context) changes based on its internal state.\n");

        Context trafficLight = new Context(RedState.getInstance());
        log.info("Initial State: {}", trafficLight.getState());

        log.info("Triggering next state...");
        trafficLight.next();
        log.info("Current State: {}", trafficLight.getState());

        log.info("Triggering next state...");
        trafficLight.next();
        log.info("Current State: {}", trafficLight.getState());

        log.info("Triggering next state...");
        trafficLight.next();
        log.info("Current State: {}", trafficLight.getState());

        log.info("Triggering next state...");
        trafficLight.next();
        log.info("Current State: {}", trafficLight.getState());

    }

}