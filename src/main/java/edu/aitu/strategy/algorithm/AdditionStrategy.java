package edu.aitu.strategy.algorithm;

import java.math.BigDecimal;

/** Adds two decimal operands without binary floating-point rounding. */
public final class AdditionStrategy implements CalculationStrategy {
    @Override
    public BigDecimal calculate(BigDecimal left, BigDecimal right) {
        return left.add(right);
    }
}
