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

        log.info("--- Flyweight Pattern Demonstration ---");
        log.info("The goal is to reuse objects (Flyweights) by sharing their intrinsic state.\n");

        log.info(">> Requesting a COMPACT car for the first time...");
        Car compact = CarFactory.create(CarType.COMPACT);
        log.info("...received object with hash code: {}", compact.hashCode());
        compact.build("red");

        log.info("\n>> Requesting a FAMILY car for the first time...");
        Car family = CarFactory.create(CarType.FAMILY);
        log.info("...received object with hash code: {}", family.hashCode());
        family.build("green");

        log.info("\n>> Requesting a SPORTS car for the first time...");
        Car sports = CarFactory.create(CarType.SPORTS);
        log.info("...received object with hash code: {}", sports.hashCode());
        sports.build("blue");

        log.info("\n>> Requesting a COMPACT car for the second time...");
        Car compact2 = CarFactory.create(CarType.COMPACT);
        log.info("...received object with hash code: {}. Note: It's the same object as the first compact car!", compact2.hashCode());
        compact2.build("green");

        log.info("\n>> Requesting a COMPACT car for the third time...");
        Car compact3 = CarFactory.create(CarType.COMPACT);
        log.info("...received object with hash code: {}. Still the same shared object!", compact3.hashCode());
        compact3.build("blue");
    }

}