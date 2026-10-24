package edu.aitu.strategy;

import edu.aitu.strategy.algorithm.AdditionStrategy;
import edu.aitu.strategy.algorithm.SubtractionStrategy;
import edu.aitu.strategy.algorithm.MultiplicationStrategy;
import edu.aitu.strategy.algorithm.CalculationStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.math.BigDecimal;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class StrategyTest {
    @ParameterizedTest
    @MethodSource("calculationCases")
    void strategiesProduceExpectedNumbers(CalculationStrategy strategy, String left,
                                         String right, String expected) {
        BigDecimal result = strategy.calculate(new BigDecimal(left), new BigDecimal(right));

        assertEquals(0, new BigDecimal(expected).compareTo(result));
    }

    static Stream<Arguments> calculationCases() {
        return Stream.of(
            Arguments.of(new AdditionStrategy(), "20", "4", "24"),
            Arguments.of(new AdditionStrategy(), "-8", "2", "-6"),
            Arguments.of(new AdditionStrategy(), "1.25", "0.75", "2"),
            Arguments.of(new AdditionStrategy(), "0", "6", "6"),
            Arguments.of(new SubtractionStrategy(), "20", "4", "16"),
            Arguments.of(new SubtractionStrategy(), "-8", "2", "-10"),
            Arguments.of(new SubtractionStrategy(), "1.25", "0.75", "0.5"),
            Arguments.of(new SubtractionStrategy(), "0", "6", "-6"),
            Arguments.of(new MultiplicationStrategy(), "20", "4", "80"),
            Arguments.of(new MultiplicationStrategy(), "-8", "2", "-16"),
            Arguments.of(new MultiplicationStrategy(), "1.25", "0.75", "0.9375"),
            Arguments.of(new MultiplicationStrategy(), "0", "6", "0")
        );
    }

    @Test
    void decimalAdditionIsExact() {
        CalculationStrategy strategy = new AdditionStrategy();

        BigDecimal result = strategy.calculate(new BigDecimal("0.1"), new BigDecimal("0.2"));

        assertEquals(new BigDecimal("0.3"), result);
    }

    @Test
    void algorithmInstanceDoesNotStorePreviousResults() {
        CalculationStrategy strategy = new MultiplicationStrategy();
        strategy.calculate(new BigDecimal("100"), new BigDecimal("100"));

        BigDecimal result = strategy.calculate(new BigDecimal("2"), new BigDecimal("3"));

        assertEquals(new BigDecimal("6"), result);
    }
}
