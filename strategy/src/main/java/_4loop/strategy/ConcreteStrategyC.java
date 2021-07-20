package _4loop.strategy;

import java.math.BigDecimal;

public class ConcreteStrategyC implements Strategy {
    @Override
    public BigDecimal algorithm(BigDecimal value) {
        return value.multiply(BigDecimal.valueOf(1.2));
    }
}
