package _4loop.strategy;

import java.math.BigDecimal;

public class ConcreteStrategyA implements Strategy {
    @Override
    public BigDecimal algorithm(BigDecimal value) {
        return value.multiply(BigDecimal.valueOf(1.1));
    }
}
