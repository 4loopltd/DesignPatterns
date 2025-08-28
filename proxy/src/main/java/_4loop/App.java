package _4loop;

import _4loop.proxy.ProxySubject;
import _4loop.proxy.Subject;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;

/**
 * Proxy Pattern Demonstration Application
 * 
 * The Proxy Pattern provides a placeholder or surrogate for another object to control
 * access to it. This pattern is useful when you want to add a level of indirection
 * to support lazy loading, access control, caching, logging, or other cross-cutting
 * concerns without changing the original object's interface.
 * 
 * Key Components demonstrated:
 * - Subject: Interface implemented by both RealSubject and Proxy (Subject)
 * - RealSubject: The actual object that performs the real work (RealSubject)
 * - Proxy: Controls access to RealSubject and may add additional behavior (ProxySubject)
 * - Client: Works with Subject interface, unaware whether using Proxy or RealSubject (App)
 * 
 * This example demonstrates:
 * - Caching proxy that stores expensive operation results
 * - Lazy loading - RealSubject created only when needed
 * - Performance improvement through caching mechanism
 * - Transparent interface - client doesn't know it's using a proxy
 */
@Slf4j
public class App {

    /**
     * Program entry point - demonstrates Proxy Pattern with caching and performance monitoring.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        log.info("--- Proxy Pattern Demonstration ---");
        log.info("Using a caching proxy to improve performance of expensive operations.\n");

        log.info("--- Creating Proxy Subject ---");
        // Client creates proxy, not knowing about RealSubject
        final Subject subject = new ProxySubject();   // Proxy controls access to RealSubject
        log.info("Proxy created - RealSubject not yet instantiated (lazy loading)\n");

        log.info("--- Testing Performance with Multiple Calls ---");
        log.info("First call should be slow (creates RealSubject and performs expensive operation)");
        log.info("Subsequent calls should be fast (proxy returns cached result)\n");

        // First call - proxy will create RealSubject and cache result
        timeAndExecute("first pass", subject);

        log.info("");
        // Second call - proxy returns cached result without calling RealSubject
        timeAndExecute("second pass", subject);

        log.info("");
        // Third call - again uses cached result, demonstrating persistent caching
        timeAndExecute("third pass", subject);

        log.info("\n--- Proxy Pattern Mechanics Explained ---");
        log.info("1. Client calls subject.process() on proxy");
        log.info("2. First call: Proxy creates RealSubject (lazy loading) and delegates call");
        log.info("3. Proxy caches the result from RealSubject");
        log.info("4. Subsequent calls: Proxy returns cached result without calling RealSubject");
        log.info("5. Client is unaware whether result comes from proxy cache or RealSubject");

        log.info("\n--- Proxy Pattern Benefits Demonstrated ---");
        log.info("1. Transparent access control - same interface as real subject");
        log.info("2. Lazy loading - expensive objects created only when needed");
        log.info("3. Caching - repeated calls avoid expensive recalculation");
        log.info("4. Performance optimization without changing client code");
        log.info("5. Additional behaviors (logging, security) can be added without modifying real subject");
        log.info("6. Separation of concerns - proxy handles cross-cutting concerns");

    }

    /**
     * Utility method to measure and log execution time of subject operations.
     * Demonstrates the performance difference between cached and non-cached calls.
     *
     * @param passName descriptive name for this execution pass
     * @param subject the subject (proxy) to execute
     */
    private static void timeAndExecute(final String passName, final Subject subject) {
        log.info(">> Executing {} - measuring performance:", passName);
        final Instant start = Instant.now();
        subject.process();                           // Polymorphic call - could be proxy or real subject
        final long duration = Duration.between(start, Instant.now()).toMillis();
        log.info("   {} completed in {} ms", passName, duration);

        if (duration < 100) {
            log.info("   ✓ Fast execution indicates cached result from proxy");
        } else {
            log.info("   ⏱ Slow execution indicates expensive operation in RealSubject");
        }
    }
}