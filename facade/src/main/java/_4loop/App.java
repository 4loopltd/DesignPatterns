package _4loop;

import _4loop.facade.EngineFacade;
import lombok.extern.slf4j.Slf4j;

/**
 * Facade Pattern Demonstration Application
 * 
 * The Facade Pattern provides a unified interface to a set of interfaces in a subsystem.
 * It defines a higher-level interface that makes the subsystem easier to use by hiding
 * the complexity of the subsystem from clients. This pattern is useful when you want
 * to provide a simple interface to a complex subsystem.
 * 
 * Key Components demonstrated:
 * - Facade: Provides simplified interface to complex subsystem (EngineFacade)
 * - Subsystem Classes: Implement subsystem functionality (various engine components)
 * - Client: Uses Facade instead of calling subsystem objects directly (App)
 * 
 * This example demonstrates:
 * - Complex engine starting/stopping procedure simplified through facade
 * - Single point of entry to subsystem functionality
 * - Client shielded from subsystem complexity
 * - Reduced coupling between client and subsystem components
 */
@Slf4j
public class App {

    /**
     * Program entry point - demonstrates Facade Pattern with engine control system.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        log.info("--- Facade Pattern Demonstration ---");
        log.info("Simplifying complex engine operations through a unified facade interface.\n");

        // Create facade - single entry point to complex engine subsystem
        EngineFacade facade = new EngineFacade();

        log.info("--- Starting Engine (Complex Operation Made Simple) ---");
        log.info("Client calls single method, facade coordinates multiple subsystem operations:");
        // Behind this simple call, the facade coordinates:
        // - Fuel system preparation
        // - Ignition system activation  
        // - Cooling system startup
        // - Oil pump activation
        // - Various sensors initialization
        facade.start();

        log.info("\n--- Engine Running ---");
        log.info("All subsystem components are now operating in harmony.");
        log.info("Client doesn't need to know about the complex coordination required.");

        log.info("\n--- Stopping Engine (Another Complex Operation) ---");
        log.info("Again, single method call handles multiple subsystem shutdowns:");
        // Behind this simple call, the facade coordinates:
        // - Gradual power reduction
        // - Cooling system continued operation
        // - Fuel system shutdown
        // - Ignition system deactivation
        // - Proper component shutdown sequence
        facade.stop();

        log.info("\n--- Facade Pattern Benefits Demonstrated ---");
        log.info("1. Provides simple interface to complex subsystem");
        log.info("2. Reduces learning curve - client only needs to know facade interface");
        log.info("3. Promotes loose coupling between client and subsystem");
        log.info("4. Doesn't prevent access to subsystem classes if needed");
        log.info("5. Centralizes common operations in one place");
        log.info("6. Makes subsystem easier to use and understand");

    }

}