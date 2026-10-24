package edu.aitu.strategy.algorithm;

import java.math.BigDecimal;

/** Common contract for interchangeable arithmetic algorithms. */
@FunctionalInterface
public interface CalculationStrategy {
    BigDecimal calculate(BigDecimal left, BigDecimal right);
}
