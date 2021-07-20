package _4loop;

import _4loop.factory.CarFactory;
import _4loop.factory.car.Car;
import _4loop.factory.car.CarType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        log.info("Creating a compact");
        Car compact = CarFactory.create(CarType.COMPACT);
        log.info(String.valueOf(compact));
        compact.build();

        log.info("Creating a family");
        Car family = CarFactory.create(CarType.FAMILY);
        log.info(String.valueOf(family));
        family.build();

        log.info("Creating a 4x4");
        Car fourByFour = CarFactory.create(CarType.FOUR_X_FOUR);
        log.info(String.valueOf(fourByFour));
        fourByFour.build();

        log.info("Creating a sports");
        Car sports = CarFactory.create(CarType.SPORTS);
        log.info(String.valueOf(sports));
        sports.build();

    }

}