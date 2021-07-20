package _4loop;

import _4loop.flyweight.CarFactory;
import _4loop.flyweight.car.Car;
import _4loop.flyweight.car.CarType;
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
        log.info(String.valueOf(compact.hashCode()));
        compact.build("red");

        log.info("Creating a family");
        Car family = CarFactory.create(CarType.FAMILY);
        log.info(String.valueOf(family.hashCode()));
        family.build("green");

        log.info("Creating a sports");
        Car sports = CarFactory.create(CarType.SPORTS);
        log.info(String.valueOf(sports.hashCode()));
        sports.build("blue");

        Car compact2 = CarFactory.create(CarType.COMPACT);
        log.info(String.valueOf(compact2.hashCode()));
        compact2.build("green");

        Car compact3 = CarFactory.create(CarType.COMPACT);
        log.info(String.valueOf(compact3.hashCode()));
        compact3.build("blue");
    }

}