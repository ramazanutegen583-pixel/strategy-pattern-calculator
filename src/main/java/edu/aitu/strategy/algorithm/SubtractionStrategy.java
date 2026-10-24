package edu.aitu.strategy.algorithm;

import java.math.BigDecimal;

/** Subtracts the right operand from the left operand. */
public final class SubtractionStrategy implements CalculationStrategy {
    @Override
    public BigDecimal calculate(BigDecimal left, BigDecimal right) {
        return left.subtract(right);
    }
}
