package _4loop.strategyoperator;

import java.math.BigDecimal;
import java.util.function.UnaryOperator;

public interface StrategyFunction extends UnaryOperator<BigDecimal> {
    /**
     * Composes this function with another. This is functionally equivalent to
     * {@link java.util.function.Function#andThen(java.util.function.Function)}, but is provided
     * here to show how composition can be built manually for demonstration purposes.
     *
     * @param after the function to apply after this function is applied.
     * @return a composed function that first applies this function and then applies the {@code after} function.
     */
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