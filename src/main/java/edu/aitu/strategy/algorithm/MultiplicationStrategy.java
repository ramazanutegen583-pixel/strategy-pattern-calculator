package edu.aitu.strategy.algorithm;

import java.math.BigDecimal;

/** Multiplies two decimal operands. */
public final class MultiplicationStrategy implements CalculationStrategy {
    @Override
    public BigDecimal calculate(BigDecimal left, BigDecimal right) {
        return left.multiply(right);
    }
}
