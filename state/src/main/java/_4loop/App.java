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

        Context trafficLight = new Context(new RedState());
        log.info("State: {}", trafficLight.getState());

        trafficLight.next();
        log.info("State: {}", trafficLight.getState());

        trafficLight.next();
        log.info("State: {}", trafficLight.getState());

        trafficLight.next();
        log.info("State: {}", trafficLight.getState());

        trafficLight.next();
        log.info("State: {}", trafficLight.getState());


    }

}