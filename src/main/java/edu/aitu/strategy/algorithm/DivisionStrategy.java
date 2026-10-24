package edu.aitu.strategy.algorithm;

import java.math.BigDecimal;
import java.math.MathContext;

/** Uses DECIMAL64 rounding for recurring quotients; zero divisors raise ArithmeticException. */
public final class DivisionStrategy implements CalculationStrategy {
    @Override
    public BigDecimal calculate(BigDecimal left, BigDecimal right) {
        return left.divide(right, MathContext.DECIMAL64);
    }
}
