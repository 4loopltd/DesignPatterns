package _4loop;

import _4loop.singleton.SingletonFour;
import _4loop.singleton.SingletonOne;
import _4loop.singleton.SingletonThree;
import _4loop.singleton.SingletonTwo;
import lombok.extern.slf4j.Slf4j;

/**
 * Singleton Pattern Demonstration Application
 * 
 * The Singleton Pattern ensures that a class has only one instance and provides
 * a global point of access to that instance. This pattern is useful when exactly
 * one object is needed to coordinate actions across the system, such as loggers,
 * thread pools, caches, or configuration objects.
 * 
 * Key Components demonstrated:
 * - Singleton Class: Controls its own instantiation and provides global access
 * - Private Constructor: Prevents external instantiation
 * - Static getInstance(): Provides controlled access to the single instance
 * - Instance Storage: Static field to hold the single instance
 * 
 * This example demonstrates four different Singleton implementations:
 * - SingletonOne: Eager initialization (thread-safe, simple)
 * - SingletonTwo: Lazy initialization (not thread-safe, memory efficient)
 * - SingletonThree: Double-checked locking (thread-safe, lazy)
 * - SingletonFour: Enhanced with shutdown hook (resource cleanup)
 */
@Slf4j
public class App {

    /**
     * Program entry point - demonstrates different Singleton implementations.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        log.info("--- Singleton Pattern Demonstration ---");
        log.info("Testing four different Singleton implementations - all should return the same instance.\n");

        log.info("--- SingletonOne: Eager Initialization ---");
        log.info("Instance created at class loading time - thread-safe by default");
        // Multiple calls should return the exact same instance
        SingletonOne singletonOneA = SingletonOne.getInstance();
        log.info("First call - SingletonOne hashCode: {}", singletonOneA.hashCode());

        SingletonOne singletonOneB = SingletonOne.getInstance();
        log.info("Second call - SingletonOne hashCode: {}", singletonOneB.hashCode());
        log.info("✓ Same hashCode confirms same instance returned");

        log.info("\n--- SingletonTwo: Lazy Initialization ---");
        log.info("Instance created only when first requested - memory efficient but not thread-safe");
        SingletonTwo singletonTwoA = SingletonTwo.getInstance();
        log.info("First call - SingletonTwo hashCode: {}", singletonTwoA.hashCode());

        SingletonTwo singletonTwoB = SingletonTwo.getInstance();
        log.info("Second call - SingletonTwo hashCode: {}", singletonTwoB.hashCode());
        log.info("✓ Same hashCode confirms lazy initialization worked correctly");

        log.info("\n--- SingletonThree: Double-Checked Locking ---");
        log.info("Thread-safe lazy initialization with performance optimization");
        SingletonThree singletonThreeA = SingletonThree.getInstance();
        log.info("First call - SingletonThree hashCode: {}", singletonThreeA.hashCode());

        SingletonThree singletonThreeB = SingletonThree.getInstance();
        log.info("Second call - SingletonThree hashCode: {}", singletonThreeB.hashCode());
        log.info("✓ Double-checked locking ensures thread safety with lazy loading");

        log.info("\n--- SingletonFour: Enhanced with Shutdown Hook ---");
        log.info("Includes proper resource cleanup and lifecycle management");
        SingletonFour singletonFourA = SingletonFour.getInstance();
        log.info("First call - SingletonFour hashCode: {}", singletonFourA.hashCode());

        SingletonFour singletonFourB = SingletonFour.getInstance();
        log.info("Second call - SingletonFour hashCode: {}", singletonFourB.hashCode());
        log.info("✓ Enhanced singleton with proper lifecycle management");

        log.info("\n--- Verifying Singleton Behavior ---");
        log.info("All getInstance() calls within each type return the identical instance:");
        log.info("SingletonOne: {} == {} ? {}", singletonOneA.hashCode(), singletonOneB.hashCode(), 
                 singletonOneA == singletonOneB);
        log.info("SingletonTwo: {} == {} ? {}", singletonTwoA.hashCode(), singletonTwoB.hashCode(), 
                 singletonTwoA == singletonTwoB);
        log.info("SingletonThree: {} == {} ? {}", singletonThreeA.hashCode(), singletonThreeB.hashCode(), 
                 singletonThreeA == singletonThreeB);
        log.info("SingletonFour: {} == {} ? {}", singletonFourA.hashCode(), singletonFourB.hashCode(), 
                 singletonFourA == singletonFourB);

        log.info("\n--- Singleton Pattern Benefits Demonstrated ---");
        log.info("1. Controlled instance creation - only one instance per class");
        log.info("2. Global access point - getInstance() available anywhere");
        log.info("3. Lazy loading options - create instance only when needed");
        log.info("4. Thread safety considerations - multiple implementation strategies");
        log.info("5. Memory efficiency - shared instance reduces object creation");
        log.info("6. Consistent state - single instance maintains global state");

        log.info("\n--- Implementation Trade-offs ---");
        log.info("Eager: Simple, thread-safe, but uses memory even if never accessed");
        log.info("Lazy: Memory efficient, but requires synchronization for thread safety");
        log.info("Double-checked: Best of both worlds, but more complex implementation");
        log.info("Enhanced: Production-ready with proper resource management");

    }

}