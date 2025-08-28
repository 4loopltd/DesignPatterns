package uk.co._4loop;

import lombok.extern.slf4j.Slf4j;
import uk.co._4loop.command.Command;
import uk.co._4loop.command.Switch;
import uk.co._4loop.command.fan.Fan;
import uk.co._4loop.command.fan.FanOffCommand;
import uk.co._4loop.command.fan.FanOnCommand;
import uk.co._4loop.command.light.Light;
import uk.co._4loop.command.light.LightOffCommand;
import uk.co._4loop.command.light.LightOnCommand;

@Slf4j
public class App {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        log.info("--- Command Pattern Demonstration ---");
        log.info("The Invoker (Switch) is decoupled from the Receiver (Light/Fan) via Command objects.\n");

        log.info("--- Configuring a switch for a Light ---");
        Light light = new Light();
        LightOnCommand loc = new LightOnCommand(light);
        LightOffCommand lfc = new LightOffCommand(light);

        Switch lightSwitch = new Switch(loc, lfc);
        log.info("Flipping light switch UP...");
        lightSwitch.flipUp();
        log.info("Flipping light switch DOWN...");
        lightSwitch.flipDown();

        log.info("\n--- Reusing the same Switch class for a Fan ---");
        Fan fan = new Fan();
        FanOnCommand foc = new FanOnCommand(fan);
        FanOffCommand ffc = new FanOffCommand(fan);

        Switch fanSwitch = new Switch(foc, ffc);
        log.info("Flipping fan switch UP...");
        fanSwitch.flipUp();
        log.info("Flipping fan switch DOWN...");
        fanSwitch.flipDown();

        log.info("\n--- Using Lambdas for Commands (Modern Java) ---");
        log.info("Since Command is a functional interface, we can use lambdas to avoid boilerplate classes.");

        // Re-using the same light object from before
        Command lightOnLambda = light::turnOn; // Method Reference
        Command lightOffLambda = light::turnOff; // Method Reference

        Switch lambdaLightSwitch = new Switch(lightOnLambda, lightOffLambda);
        log.info("Flipping lambda light switch UP...");
        lambdaLightSwitch.flipUp();
        log.info("Flipping lambda light switch DOWN...");
        lambdaLightSwitch.flipDown();

    }

}