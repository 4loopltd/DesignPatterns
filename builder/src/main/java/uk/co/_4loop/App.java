package uk.co._4loop;

import lombok.extern.slf4j.Slf4j;
import uk.co._4loop.builder.Vehicle;
import uk.co._4loop.builder.VehicleBuilder;
import uk.co._4loop.builder.parts.BodyColour;
import uk.co._4loop.builder.parts.EngineType;
import uk.co._4loop.builder.parts.Gearbox;
import uk.co._4loop.builder.parts.Wheels;

@Slf4j
public class App {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        Vehicle car = new VehicleBuilder("car")
                .setWheels(Wheels.FOUR)
                .setEngineType(EngineType.ELECTRIC)
                .setGearbox(Gearbox.AUTOMATIC)
                .setBodyColour(BodyColour.GREEN)
                .build();
        log.info(car.toString());

        Vehicle motorbike = new VehicleBuilder("motorbike")
                .setWheels(Wheels.TWO)
                .setEngineType(EngineType.PETROL)
                .setGearbox(Gearbox.MANUAL)
                .setBodyColour(BodyColour.RED)
                .build();
        log.info(motorbike.toString());

        Vehicle van = new VehicleBuilder("robin")
                .setWheels(Wheels.THREE)
                .setEngineType(EngineType.DIESEL)
                .setGearbox(Gearbox.MANUAL)
                .setBodyColour(BodyColour.YELLOW)
                .build();
        log.info(van.toString());

    }
}
