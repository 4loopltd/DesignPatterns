package _4loop;

import _4loop.template.FamilyCarBuilder;
import _4loop.template.SportsCarBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        log.info("Building Sports Car");
        new SportsCarBuilder()
                .buildCar()
                .getCarParts()
                .forEach((k) -> log.info("Part : " + k));

        log.info("Building Family Car");
        new FamilyCarBuilder()
                .buildCar()
                .getCarParts()
                .forEach((k) -> log.info("Part : " + k));
    }

}