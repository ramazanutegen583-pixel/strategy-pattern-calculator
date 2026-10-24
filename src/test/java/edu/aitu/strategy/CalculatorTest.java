package edu.aitu.strategy;

import edu.aitu.strategy.context.Calculator;
import edu.aitu.strategy.algorithm.AdditionStrategy;
import edu.aitu.strategy.algorithm.SubtractionStrategy;
import edu.aitu.strategy.algorithm.MultiplicationStrategy;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

/** Each test builds its own context; no shared mutable fixtures or external resources. */
class CalculatorTest {
    @Test
    void constructorRejectsMissingStrategy() {
        assertThrows(NullPointerException.class, () -> new Calculator(null));
    }

    @Test
    void sameContextSwitchesAlgorithmsAtRuntime() {
        Calculator calculator = new Calculator(new AdditionStrategy());
        BigDecimal left = new BigDecimal("20");
        BigDecimal right = new BigDecimal("4");

        assertEquals(new BigDecimal("24"), calculator.calculate(left, right));
        calculator.setStrategy(new SubtractionStrategy());
        assertEquals(new BigDecimal("16"), calculator.calculate(left, right));
        calculator.setStrategy(new MultiplicationStrategy());
        assertEquals(new BigDecimal("80"), calculator.calculate(left, right));
    }

    @Test
    void customStrategyWorksWithoutContextChanges() {
        Calculator calculator = new Calculator((left, right) -> new BigDecimal("42"));

        BigDecimal result = calculator.calculate(BigDecimal.ONE, BigDecimal.TEN);

        assertEquals(new BigDecimal("42"), result);
    }

    @Test
    void rejectedReplacementPreservesPreviousStrategy() {
        Calculator calculator = new Calculator(new AdditionStrategy());

        assertThrows(NullPointerException.class, () -> calculator.setStrategy(null));

        assertEquals(new BigDecimal("3"), calculator.calculate(BigDecimal.ONE, new BigDecimal("2")));
    }

    @Test
    void missingLeftOperandIsRejected() {
        Calculator calculator = new Calculator(new AdditionStrategy());
        assertThrows(NullPointerException.class, () -> calculator.calculate(null, BigDecimal.ONE));
    }

    @Test
    void missingRightOperandIsRejected() {
        Calculator calculator = new Calculator(new AdditionStrategy());
        assertThrows(NullPointerException.class, () -> calculator.calculate(BigDecimal.ONE, null));
    }

    @Test
    void switchingBackRestoresOriginalAlgorithm() {
        Calculator calculator = new Calculator(new AdditionStrategy());
        calculator.setStrategy(new MultiplicationStrategy());
        calculator.setStrategy(new AdditionStrategy());

        BigDecimal result = calculator.calculate(new BigDecimal("2"), new BigDecimal("3"));

        assertEquals(new BigDecimal("5"), result);
    }
}
