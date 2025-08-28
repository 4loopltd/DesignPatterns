package _4loop;

import _4loop.visitor.PrintVisitor;
import _4loop.visitor.parts.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        log.info("--- Visitor Pattern Demonstration ---");
        log.info("Building a composite object structure (a Car with Parts).");

        Car car = new Car();
        car.add(new Frame());
        car.add(new Engine());
        car.add(new Body());
        car.add(new Wheels());

        log.info("\nApplying a Visitor to perform an operation on the structure without modifying the parts.");
        car.accept(new PrintVisitor());
    }

}