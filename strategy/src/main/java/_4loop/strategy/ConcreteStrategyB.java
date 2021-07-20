package _4loop.strategy;

import java.math.BigDecimal;

public class ConcreteStrategyB implements Strategy {
    @Override
    public BigDecimal algorithm(BigDecimal value) {
        return value.multiply(BigDecimal.valueOf(1.15));
    }
}
