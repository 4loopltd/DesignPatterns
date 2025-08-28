package uk.co._4loop;

import lombok.extern.slf4j.Slf4j;
import uk.co._4loop.callback.SimpleTask;
import uk.co._4loop.callback.Task;

/**
 * Callback Pattern Demonstration Application
 * 
 * The Callback Pattern allows a piece of executable code to be passed as an argument
 * to other code, which is expected to call back (execute) the argument at some convenient time.
 * This pattern enables inversion of control and promotes loose coupling by allowing
 * the called code to call back into the calling code without having explicit knowledge
 * of the caller's implementation.
 * 
 * Key Components demonstrated:
 * - Task: The component that accepts and executes callbacks
 * - Callback: The executable code passed to the task (lambda expression/functional interface)
 * - Client: Provides the callback implementation and initiates the task
 * 
 * This example demonstrates:
 * - Passing behavior (callback) as a parameter using lambda expressions
 * - Inversion of control - the task decides when to execute the callback
 * - Loose coupling - task doesn't need to know about specific callback implementations
 * - Modern Java functional programming with method references and lambdas
 */
@Slf4j
public class App {

    /**
     * Program entry point - demonstrates Callback Pattern with task execution.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        log.info("--- Callback Pattern Demonstration ---");
        log.info("Passing executable behavior as parameters for flexible task completion handling.\n");

        // Create a task that accepts callback behavior
        Task task = new SimpleTask();

        log.info("--- Executing task with lambda callback ---");
        // Pass callback behavior using lambda expression
        // The task will execute this callback when it completes
        task.executeWith(() -> log.info("Task completed successfully via lambda callback!"));

        log.info("\n--- Executing task with different callback behavior ---");
        // Different callback implementation - same task, different completion behavior
        task.executeWith(() -> {
            log.info("Alternative completion handler executed!");
            log.info("This demonstrates callback flexibility.");
        });

        log.info("\n--- Executing task with method reference callback ---");
        // Using method reference as callback - another functional approach
        task.executeWith(App::onTaskComplete);

        log.info("\n--- Callback Pattern Benefits Demonstrated ---");
        log.info("1. Flexible response to events without tight coupling");
        log.info("2. Inversion of control - callee decides when to invoke callback");
        log.info("3. Reusable tasks with customizable completion behavior");
        log.info("4. Modern Java functional programming with lambdas and method references");
        log.info("5. Promotes separation of concerns between task execution and completion handling");
    }

    /**
     * Static method used as callback via method reference.
     * Demonstrates that callbacks can be method references too.
     */
    private static void onTaskComplete() {
        log.info("Method reference callback executed - task is done!");
    }
}

