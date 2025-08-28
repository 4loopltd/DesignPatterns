package _4loop;

import _4loop.memento.Caretaker;
import _4loop.memento.Message;
import lombok.extern.slf4j.Slf4j;

/**
 * Memento Pattern Demonstration Application
 * 
 * The Memento Pattern captures and externalizes an object's internal state so that
 * the object can be restored to this state later, without violating encapsulation.
 * This pattern is useful when you need to provide undo functionality, checkpoint
 * systems, or state rollback mechanisms.
 * 
 * Key Components demonstrated:
 * - Originator: Object whose state needs to be saved and restored (Message)
 * - Memento: Stores internal state of Originator (MessageMemento)
 * - Caretaker: Manages mementos but doesn't examine their contents (Caretaker)
 * 
 * This example demonstrates:
 * - Text editor functionality with undo capability
 * - State preservation without exposing internal object structure
 * - Caretaker managing state history without knowing state details
 * - Restoration to previous states while maintaining encapsulation
 */
@Slf4j
public class App {

    /**
     * Program entry point - demonstrates Memento Pattern with text editor undo functionality.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        log.info("--- Memento Pattern Demonstration ---");
        log.info("Implementing undo functionality for a text editor using state snapshots.\n");

        log.info("--- Creating Text Editor (Caretaker + Originator) ---");
        // Caretaker manages the originator and its mementos
        Caretaker messageEditor = new Caretaker(new Message());

        log.info("--- Writing and Saving First Version ---");
        messageEditor.write("The Memento pattern contains a snapshot of the state of an object, so that the object can return to its original state without having to reveal its content to the rest of the world.");
        log.info("Current text: {}", messageEditor.read());

        // Save creates a memento containing the current state
        messageEditor.save();                          // Caretaker asks Originator for memento
        log.info("✓ State saved to memento");

        log.info("\n--- Modifying Text (Second Version) ---");
        messageEditor.write("The Memento pattern allows the state of an object to be captured and stored.");
        log.info("Modified text: {}", messageEditor.read());

        log.info("\n--- Demonstrating Undo Operation ---");
        log.info(">> Restoring to saved state using memento:");
        // Undo restores the originator's state from the saved memento
        messageEditor.undo();                          // Caretaker provides memento back to Originator
        log.info("After undo: {}", messageEditor.read());

        log.info("\n--- Making New Changes After Undo ---");
        messageEditor.write("The Memento pattern allows the state of an object to be captured and stored. The object can be put back to this (previous) state, when needed.");
        log.info("Final text: {}", messageEditor.read());

        log.info("\n--- Memento Pattern Mechanics ---");
        log.info("1. Originator (Message) creates memento containing its current state");
        log.info("2. Caretaker stores memento without examining its contents");
        log.info("3. When undo is needed, Caretaker gives memento back to Originator");
        log.info("4. Originator restores its state from memento data");
        log.info("5. Encapsulation maintained - only Originator knows memento structure");

        log.info("\n--- Memento Pattern Benefits Demonstrated ---");
        log.info("1. Preserves encapsulation boundaries - external objects can't access internal state");
        log.info("2. Simplifies Originator - doesn't need to manage multiple versions of itself");
        log.info("3. Caretaker can manage complex undo/redo logic without knowing state details");
        log.info("4. Supports multiple checkpoint states (can be extended to stack of mementos)");
        log.info("5. Clean separation of concerns between state management and business logic");

    }

}