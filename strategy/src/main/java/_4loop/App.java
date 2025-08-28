package _4loop;

import _4loop.strategy.ConcreteStrategyA;
import _4loop.strategy.ConcreteStrategyB;
import _4loop.strategy.ConcreteStrategyC;
import _4loop.strategy.Strategy;
import _4loop.strategyoperator.StrategyFunction;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static _4loop.strategyoperator.StrategyFunction.*;

/**
 * Strategy Pattern Demonstration Application
 * 
 * The Strategy Pattern defines a family of algorithms, encapsulates each one,
 * and makes them interchangeable. This pattern lets the algorithm vary independently
 * from clients that use it. It's useful when you have multiple ways to perform
 * a task and want to choose the approach at runtime.
 * 
 * Key Components demonstrated:
 * - Strategy: Interface common to all concrete strategies (Strategy, StrategyFunction)
 * - ConcreteStrategy: Implements different algorithms using Strategy interface 
 *   (ConcreteStrategyA, ConcreteStrategyB, ConcreteStrategyC)
 * - Context: Uses Strategy interface to call algorithm defined by ConcreteStrategy
 * - Client: Configures Context with specific ConcreteStrategy (App)
 * 
 * This example demonstrates:
 * - Traditional OOP approach with concrete strategy classes
 * - Modern Java functional approaches with lambdas and method references
 * - Strategy composition and chaining for complex algorithms
 * - Runtime algorithm selection and interchangeability
 */
@Slf4j
public class App {

    /**
     * Program entry point - demonstrates various Strategy Pattern implementations.
     *
     * @param args command line args
     */
    @SuppressWarnings("Convert2Lambda")
    public static void main(final String[] args) {

        log.info("--- Strategy Pattern Demonstration ---");
        log.info("Multiple approaches to implement interchangeable algorithms.");
        log.info("A base amount of 100 will be used for all calculations.\n");
        BigDecimal amount = BigDecimal.valueOf(100.0);

        log.info("--- 1. Classic OOP Strategy Pattern ---");
        log.info("Using separate concrete classes for each algorithm - traditional approach.");
        // Each strategy encapsulates a different algorithm
        Strategy strategyA = new ConcreteStrategyA();  // 10% increase algorithm
        Strategy strategyB = new ConcreteStrategyB();  // 15% increase algorithm
        Strategy strategyC = new ConcreteStrategyC();  // 20% increase algorithm

        log.info("Strategy A result (10% increase): {}", strategyA.algorithm(amount));
        log.info("Strategy B result (15% increase): {}", strategyB.algorithm(amount));
        log.info("Strategy C result (20% increase): {}", strategyC.algorithm(amount));

        log.info("\n--- 2. Anonymous Class Implementation ---");
        log.info("Defining a strategy on-the-fly without creating a named class.");
        // Strategy defined inline - useful for one-off or simple algorithms
        Strategy strategyD = new Strategy() {
            @Override
            public BigDecimal algorithm(BigDecimal value) {
                return value.multiply(BigDecimal.valueOf(1.5)); // 50% increase
            }
        };
        log.info("Anonymous strategy result (50% increase): {}", strategyD.algorithm(amount));

        log.info("\n--- 3. Lambda Implementation (Modern Java Functional Approach) ---");
        log.info("Using lambda expressions for concise, functional strategy implementation.");
        // Lambda expression as strategy - most concise for simple algorithms
        Strategy strategyE = a -> a.multiply(BigDecimal.valueOf(1.75)); // 75% increase
        log.info("Lambda strategy result (75% increase): {}", strategyE.algorithm(amount));

        log.info("\n--- 4. Functional Composition: Strategy Combination ---");
        log.info("Combining multiple strategies into a single composite strategy using streams.");
        // Advanced: combining multiple strategies into one
        List<StrategyFunction> strategiesToCombine = Arrays.asList(small(), medium(), large());
        StrategyFunction compositeStrategy = strategiesToCombine
                .stream()
                .reduce(v -> v, StrategyFunction::combine); // Combines strategies sequentially
        log.info("Combined strategies result: {}", compositeStrategy.apply(amount));

        log.info("\n--- 5. Functional Chaining: Strategy Pipeline ---");
        log.info("Chaining strategies using andThen() for pipeline processing.");
        // Alternative composition approach using Function.andThen()
        final Function<BigDecimal, BigDecimal> chainedStrategy = StrategyFunction
                .small()           // First: small adjustment
                .andThen(medium()) // Then: medium adjustment
                .andThen(large()); // Finally: large adjustment
        log.info("Chained strategies result: {}", chainedStrategy.apply(amount));

        log.info("\n--- Strategy Selection at Runtime ---");
        log.info("Demonstrating dynamic strategy selection based on conditions.");
        // Simulating runtime strategy selection
        String condition = "medium"; // Could come from user input, config, etc.
        Strategy dynamicStrategy = selectStrategy(condition);
        log.info("Dynamically selected '{}' strategy result: {}", condition, dynamicStrategy.algorithm(amount));

        log.info("\n--- Strategy Pattern Benefits Demonstrated ---");
        log.info("1. Algorithms are interchangeable - easy to swap at runtime");
        log.info("2. New strategies can be added without modifying existing code");
        log.info("3. Eliminates conditional statements for algorithm selection");
        log.info("4. Each algorithm is encapsulated and can be tested independently");
        log.info("5. Modern Java supports functional strategies with lambdas");
        log.info("6. Strategies can be composed and chained for complex operations");
        log.info("7. Follows Open/Closed Principle - open for extension, closed for modification");

    }

    /**
     * Demonstrates runtime strategy selection based on conditions.
     * In real applications, this might be based on user preferences, 
     * configuration settings, or environmental factors.
     */
    private static Strategy selectStrategy(String condition) {
        switch (condition.toLowerCase()) {
            case "small": return amount -> amount.multiply(BigDecimal.valueOf(1.05));
            case "medium": return amount -> amount.multiply(BigDecimal.valueOf(1.10));
            case "large": return amount -> amount.multiply(BigDecimal.valueOf(1.15));
            default: return amount -> amount; // No change strategy
        }
    }

}