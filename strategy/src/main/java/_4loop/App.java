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

@Slf4j
public class App {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    @SuppressWarnings("Convert2Lambda")
    public static void main(final String[] args) {

        log.info("--- Strategy Pattern Demonstration ---");
        log.info("A base amount of 100 will be used for all calculations.\n");
        BigDecimal amount = BigDecimal.valueOf(100.0);

        log.info("--- 1. Classic OOP Strategy Pattern ---");
        log.info("Using separate concrete classes for each algorithm.");
        Strategy strategyA = new ConcreteStrategyA();
        Strategy strategyB = new ConcreteStrategyB();
        Strategy strategyC = new ConcreteStrategyC();

        log.info("Result for Strategy A (1.1x): {}", strategyA.algorithm(amount));
        log.info("Result for Strategy B (1.15x): {}", strategyB.algorithm(amount));
        log.info("Result for Strategy C (1.2x): {}", strategyC.algorithm(amount));


        log.info("\n--- 2. Anonymous Class Implementation ---");
        log.info("Defining a strategy on-the-fly without a named class.");
        Strategy strategyD = new Strategy() {
            @Override
            public BigDecimal algorithm(BigDecimal value) {
                return value.multiply(BigDecimal.valueOf(1.5));
            }
        };
        log.info("Result for Strategy D (1.5x): {}", strategyD.algorithm(amount));


        log.info("\n--- 3. Lambda Implementation (Modern Java) ---");
        log.info("Using a lambda for a concise, functional implementation.");
        Strategy strategyE = a -> a.multiply(BigDecimal.valueOf(1.75));
        log.info("Result for Strategy E (1.75x): {}", strategyE.algorithm(amount));


        log.info("\n--- 4. Functional Composition: Reducing a list of strategies ---");
        log.info("Combining multiple functional strategies from a list into a single strategy.");
        List<StrategyFunction> combined = Arrays.asList(small(), medium(), large());
        StrategyFunction strategy = combined
                .stream()
                .reduce(v -> v, StrategyFunction::combine);
        log.info("Result for combined strategies (small, medium, large): {}", strategy.apply(amount));


        log.info("\n--- 5. Functional Composition: Chaining strategies with andThen ---");
        log.info("Using the standard 'andThen' to chain functional strategies. Note the result is identical to reduce.");
        final Function<BigDecimal, BigDecimal> chained = StrategyFunction
                .small()
                .andThen(medium())
                .andThen(large());
        log.info("Result for chained strategies (small, medium, large): {}", chained.apply(amount));
    }

}