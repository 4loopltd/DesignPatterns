package _4loop;

import _4loop.decorator.*;
import lombok.extern.slf4j.Slf4j;

/**
 * Decorator Pattern Demonstration Application
 * 
 * The Decorator Pattern attaches additional responsibilities to an object dynamically.
 * Decorators provide a flexible alternative to subclassing for extending functionality.
 * This pattern is useful when you want to add behavior to objects without altering
 * their structure, and when extension by subclassing would be impractical.
 * 
 * Key Components demonstrated:
 * - Component: Interface for objects that can have responsibilities added (Message)
 * - ConcreteComponent: Object to which additional responsibilities are attached (TxtMessage)
 * - Decorator: Maintains reference to Component and conforms to Component interface (MessageDecorator)
 * - ConcreteDecorator: Adds responsibilities to the component (EncodedMessage, DecodedMessage)
 * 
 * This example demonstrates:
 * - Message processing pipeline where transformations can be applied dynamically
 * - Decorators wrapping other decorators to create chains of behavior
 * - Runtime composition of functionality without inheritance
 * - Transparent interface - decorated objects can be used wherever original objects can
 */
@Slf4j
public class App {

    /**
     * Program entry point - demonstrates Decorator Pattern with message processing.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        log.info("--- Decorator Pattern Demonstration ---");
        log.info("Adding behavior to messages dynamically through decoration.\n");

        log.info("--- Creating Base Message (ConcreteComponent) ---");
        // ConcreteComponent - basic functionality without any decorations
        Message message = new TxtMessage("Hello");
        log.info("Original message: {}", message.getMessage());

        log.info("\n--- Applying First Decoration (Encoding) ---");
        // First Decorator - adds encoding behavior to the message
        MessageDecorator encoded = new EncodedMessage(message);
        log.info("After encoding: {}", encoded.getMessage());

        log.info("\n--- Applying Second Decoration (Decoding) ---");
        // Second Decorator - adds decoding behavior, wrapping the already encoded message
        // This demonstrates decorator chaining - decorators can wrap other decorators
        MessageDecorator decoded = new DecodedMessage(encoded);
        log.info("After decoding: {}", decoded.getMessage());

        log.info("\n--- Demonstrating Decorator Flexibility ---");
        // We can create different decoration combinations without changing the base classes
        Message anotherMessage = new TxtMessage("World");

        // Skip encoding, go directly to "decoding" (which might just pass through)
        MessageDecorator directDecoded = new DecodedMessage(anotherMessage);
        log.info("Direct decode of '{}': {}", anotherMessage.getMessage(), directDecoded.getMessage());

        // Double encoding example
        MessageDecorator doubleEncoded = new EncodedMessage(new EncodedMessage(anotherMessage));
        log.info("Double encoded '{}': {}", anotherMessage.getMessage(), doubleEncoded.getMessage());

        log.info("\n--- Decorator Pattern Benefits Demonstrated ---");
        log.info("1. Adds behavior dynamically without altering object structure");
        log.info("2. Alternative to subclassing for extending functionality");
        log.info("3. Decorators can be combined in any order and quantity");
        log.info("4. Follows Single Responsibility Principle - each decorator has one purpose");
        log.info("5. Transparent interface - decorated objects implement same interface as originals");
        log.info("6. Runtime composition allows for flexible behavior combinations");

    }

}