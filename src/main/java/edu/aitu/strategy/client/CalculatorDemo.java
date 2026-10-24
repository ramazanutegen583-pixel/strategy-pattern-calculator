package edu.aitu.strategy.client;

import edu.aitu.strategy.context.Calculator;
import edu.aitu.strategy.algorithm.AdditionStrategy;
import edu.aitu.strategy.algorithm.SubtractionStrategy;
import edu.aitu.strategy.algorithm.MultiplicationStrategy;
import java.math.BigDecimal;

/** Composition root: selects strategies and presents results; no arguments are needed. */
public final class CalculatorDemo {
    private CalculatorDemo() { }

    public static void main(String[] args) {
        System.out.println("============================================================");
        System.out.println("CALCULATOR - STRATEGY PATTERN DEMONSTRATION");
        System.out.println("One Calculator object; interchangeable arithmetic algorithms.");
        System.out.println("The client selects a strategy; the context delegates the work.");
        System.out.println("============================================================");
        Calculator calculator = new Calculator(new AdditionStrategy());

        System.out.println("\n1. INITIAL STRATEGY: ADDITION");
        showCalculation(calculator, "Addition", "20", "4");
        showCalculation(calculator, "Addition", "0.1", "0.2");

        System.out.println("\n2. RUNTIME SWITCH: SUBTRACTION");
        calculator.setStrategy(new SubtractionStrategy());
        showCalculation(calculator, "Subtraction", "20", "4");
        showCalculation(calculator, "Subtraction", "-8", "2");

        System.out.println("\n3. RUNTIME SWITCH: MULTIPLICATION");
        calculator.setStrategy(new MultiplicationStrategy());
        showCalculation(calculator, "Multiplication", "20", "4");
        showCalculation(calculator, "Multiplication", "1.25", "0.75");

        System.out.println("\n4. SWITCH BACK: ADDITION");
        calculator.setStrategy(new AdditionStrategy());
        showCalculation(calculator, "Addition", "20", "4");
        System.out.println("\nThe same context was reused for every calculation.");
        System.out.println("DEMONSTRATION COMPLETED SUCCESSFULLY");
    }

    private static void showCalculation(Calculator calculator, String operation,
                                        String left, String right) {
        BigDecimal result = calculator.calculate(new BigDecimal(left), new BigDecimal(right));
        System.out.println("Client selected: " + operation);
        System.out.println("Operands: " + left + " and " + right);
        System.out.println("Context action: delegate to the current CalculationStrategy");
        System.out.println("Result: " + result.stripTrailingZeros().toPlainString());
    }
}
