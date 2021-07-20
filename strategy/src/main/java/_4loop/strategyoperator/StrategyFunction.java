package _4loop.strategyoperator;

import java.math.BigDecimal;
import java.util.function.UnaryOperator;

public interface StrategyFunction extends UnaryOperator<BigDecimal> {
    default StrategyFunction combine(StrategyFunction after) {
        return v -> after.apply(this.apply(v));
    }

    static StrategyFunction small() {
        return a -> a.multiply(BigDecimal.valueOf(1.1));
    }

    static StrategyFunction medium() {
        return a -> a.multiply(BigDecimal.valueOf(1.15));
    }

    static StrategyFunction large() {
        return a -> a.multiply(BigDecimal.valueOf(1.2));
    }
}