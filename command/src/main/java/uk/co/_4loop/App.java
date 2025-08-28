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

/**
 * Command Pattern Demonstration Application
 * 
 * The Command Pattern encapsulates a request as an object, thereby allowing you to
 * parameterize clients with different requests, queue or log requests, and support
 * undoable operations. This pattern decouples the object that invokes the operation
 * from the object that performs it.
 * 
 * Key Components demonstrated:
 * - Command: Interface that declares method for executing operations (Command)
 * - ConcreteCommand: Implements Command and defines binding between Receiver and action
 *   (LightOnCommand, LightOffCommand, FanOnCommand, FanOffCommand)
 * - Receiver: Knows how to perform operations (Light, Fan)
 * - Invoker: Asks command to carry out request (Switch)
 * - Client: Creates ConcreteCommand and sets its Receiver (App)
 * 
 * This example demonstrates:
 * - Decoupling invoker (Switch) from receiver (Light/Fan) 
 * - Same invoker working with different receivers through commands
 * - Command objects as first-class entities that can be stored, passed, and executed
 * - Modern Java functional approach with lambda expressions and method references
 */
@Slf4j
public class App {

    /**
     * Program entry point - demonstrates Command Pattern with home automation switches.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        log.info("--- Command Pattern Demonstration ---");
        log.info("The Invoker (Switch) is decoupled from the Receiver (Light/Fan) via Command objects.\n");

        log.info("--- Configuring Switch for Light (Traditional Command Objects) ---");
        // Receiver - knows how to perform the actual operations
        Light light = new Light();

        // ConcreteCommands - encapsulate receiver calls as objects
        LightOnCommand loc = new LightOnCommand(light);   // Encapsulates light.turnOn()
        LightOffCommand lfc = new LightOffCommand(light); // Encapsulates light.turnOff()

        // Invoker - executes commands without knowing about receivers
        Switch lightSwitch = new Switch(loc, lfc);        // Switch configured with light commands
        log.info("Flipping light switch UP...");
        lightSwitch.flipUp();                             // Executes light on command
        log.info("Flipping light switch DOWN...");
        lightSwitch.flipDown();                           // Executes light off command

        log.info("\n--- Reusing same Switch class for Fan (Demonstrates Flexibility) ---");
        // Same invoker (Switch) can control different receivers through different commands
        Fan fan = new Fan();                              // Different receiver type
        FanOnCommand foc = new FanOnCommand(fan);         // Commands for fan operations
        FanOffCommand ffc = new FanOffCommand(fan);

        Switch fanSwitch = new Switch(foc, ffc);          // Same Switch class, different commands
        log.info("Flipping fan switch UP...");
        fanSwitch.flipUp();                               // Same method, different behavior
        log.info("Flipping fan switch DOWN...");
        fanSwitch.flipDown();

        log.info("\n--- Using Lambdas for Commands (Modern Java Approach) ---");
        log.info("Since Command is a functional interface, we can use lambdas to avoid boilerplate classes.");

        // Modern approach - using method references as commands
        // Eliminates need for separate command classes for simple operations
        Command lightOnLambda = light::turnOn;            // Method Reference as Command
        Command lightOffLambda = light::turnOff;          // Functional interface implementation

        Switch lambdaLightSwitch = new Switch(lightOnLambda, lightOffLambda);
        log.info("Flipping lambda light switch UP...");
        lambdaLightSwitch.flipUp();                       // Lambda command execution
        log.info("Flipping lambda light switch DOWN...");
        lambdaLightSwitch.flipDown();

        log.info("\n--- Command Pattern Benefits Demonstrated ---");
        log.info("1. Decouples invoker from receiver - Switch doesn't know about Light/Fan");
        log.info("2. Commands are first-class objects - can be stored, passed, queued");
        log.info("3. Easy to add new commands without changing existing code");
        log.info("4. Supports undo operations (commands can store state)");
        log.info("5. Enables macro commands (composite commands)");
        log.info("6. Modern Java allows lambda expressions for simple commands");

    }

}