# Strategy Calculator

Assignment 5 Software Design Patterns

## 1 Introduction

The project is a calculator with four interchangeable algorithms: addition, subtraction, multiplication, and division. CalculatorDemo chooses a CalculationStrategy for Calculator. The same Calculator object switches algorithms at runtime. For inputs 20 and 4, the four strategies return 24, 16, 80, and 5.

BigDecimal handles decimal values. Division uses DECIMAL64 rounding and rejects zero divisors. All 30 unit tests passed.

## 2 UML class diagram

![Complete class diagram](../docs/class-diagram.png)

CalculatorDemo is the client, Calculator is the context, and CalculationStrategy is the common interface. Four classes implement the algorithms. The diagram also includes both test classes, all declared fields, methods, and explicit constructors.

## 3 Clean Code

### Clear and independent tests

Chapter 9. Each test creates its own data, runs one operation, and checks the result. Fixed inputs make tests repeatable.

```java
// Setup, operation, and check use fixed data.
Calculator calculator = new Calculator((left, right) -> new BigDecimal("42"));
BigDecimal result = calculator.calculate(BigDecimal.ONE, BigDecimal.TEN);
assertEquals(new BigDecimal("42"), result);
```

### Single responsibility

Chapter 10. Each strategy contains one arithmetic operation. Calculator delegates execution, while CalculatorDemo selects strategies and prints results.

```java
// AdditionStrategy owns the addition algorithm.
public BigDecimal calculate(BigDecimal left, BigDecimal right) {
    return left.add(right);
}
```

### Independence from concrete algorithms

Chapter 10. Calculator depends on CalculationStrategy and delegates through it. It has no if or switch for selecting an operation.

```java
private CalculationStrategy strategy;
// After checking the operands, delegate through the interface.
return strategy.calculate(left, right);
```

### Organizing for change

Chapter 10. DivisionStrategy implements the same contract. Adding it required no changes to Calculator, CalculationStrategy, or the three existing strategies.

```java
// DivisionStrategy adds an algorithm without changing the context.
public BigDecimal calculate(BigDecimal left, BigDecimal right) {
    return left.divide(right, MathContext.DECIMAL64);
}
```

### Separate construction from use

Chapter 11. CalculatorDemo creates strategies and passes them to Calculator. Calling setStrategy changes the algorithm while the Calculator object stays the same.

```java
// The client creates and replaces the algorithm.
Calculator calculator = new Calculator(new AdditionStrategy());
calculator.setStrategy(new SubtractionStrategy());
```

## 4 Conclusion

Strategy allows the calculation to change at runtime without editing Calculator. New algorithms can be added as strategy classes. This improves flexibility, but adds classes and requires the client to choose the strategy.

## Repository

https://github.com/ramazanutegen583-pixel/strategy-pattern-calculator

Reference: Robert C. Martin, Clean Code (2008), Chapters 9, 10, and 11.
