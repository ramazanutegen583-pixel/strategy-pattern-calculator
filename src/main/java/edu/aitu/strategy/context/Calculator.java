package edu.aitu.strategy.context;

import edu.aitu.strategy.algorithm.CalculationStrategy;
import java.math.BigDecimal;
import java.util.Objects;

/** Delegates calculation through the strategy contract; construction belongs to the client. */
public final class Calculator {
    private CalculationStrategy strategy;

    public Calculator(CalculationStrategy strategy) {
        setStrategy(strategy);
    }

    public void setStrategy(CalculationStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "Strategy must not be null.");
    }

    public BigDecimal calculate(BigDecimal left, BigDecimal right) {
        Objects.requireNonNull(left, "Left operand must not be null.");
        Objects.requireNonNull(right, "Right operand must not be null.");
        return strategy.calculate(left, right);
    }
}
