package _4loop;

import _4loop.facade.EngineFacade;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        EngineFacade facade = new EngineFacade();

        log.info("Start Engine");
        facade.start();

        log.info("Stop Engine");
        facade.stop();

    }

}