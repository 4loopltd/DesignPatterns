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

        BigDecimal amount = BigDecimal.valueOf(100.0);

        Strategy strategyA = new ConcreteStrategyA();
        Strategy strategyB = new ConcreteStrategyB();
        Strategy strategyC = new ConcreteStrategyC();

        log.info("A:{}", strategyA.algorithm(amount));
        log.info("B:{}", strategyB.algorithm(amount));
        log.info("C:{}", strategyC.algorithm(amount));


        // Anonymous
        Strategy strategyD = new Strategy() {
            @Override
            public BigDecimal algorithm(BigDecimal value) {
                return value.multiply(BigDecimal.valueOf(1.5));
            }
        };
        log.info("D:{}", strategyD.algorithm(amount));


        // Lambda
        Strategy strategyE = a -> a.multiply(BigDecimal.valueOf(1.75));
        log.info("E:{}", strategyE.algorithm(amount));


        // Accumulative
        List<StrategyFunction> combined = Arrays.asList(small(), medium(), large());
        StrategyFunction strategy = combined
                .stream()
                .reduce(v -> v, StrategyFunction::combine);
        log.info("F:{}", strategy.apply(amount));


        // Chained
        final Function<BigDecimal, BigDecimal> chained = StrategyFunction
                .small()
                .andThen(medium())
                .andThen(large());
        log.info("G:{}", chained.apply(amount));


        // etc...
    }

}