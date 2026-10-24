# Strategy Calculator Assignment Report

Assignment 5 Software Design Patterns Java 17

## 1 Introduction

This project uses the assignment's suggested Calculator topic. Addition, subtraction, multiplication, and division form a family of interchangeable algorithms. Calculator stores a CalculationStrategy and delegates calculation through that contract. CalculatorDemo selects strategies and replaces them on one context at runtime.

BigDecimal operands preserve exact decimal addition, subtraction, and multiplication. Division uses DECIMAL64: 16 significant digits with HALF_EVEN rounding. A zero divisor raises ArithmeticException. The console client catches the expected error and continues; it needs no arguments or interactive input.

## 2 UML class diagram

![Complete class diagram](../docs/class-diagram.png)

The complete diagram contains 6 application classes, 1 strategy interface, and 2 test classes: 8 classes and 1 interface overall. Every declared field, method, and explicit constructor is included, with types and visibility. Underlining marks static methods and italics mark the abstract interface operation. Dashed hollow triangles represent interface realization. Supplemental client and test dependencies are listed as diagram notes and are explicit edges in the editable PlantUML source.

The context holds one current strategy reference. The demo creates one Calculator and five strategy instances over the run because AdditionStrategy is selected twice with separate instances. This excludes Java library objects. The complete local-variable register is in docs/uml-inventory.md.

## 3 Clean Code Chapters 9 10 and 11

### Readable tests

Chapter 9 Unit Tests. Tests make the setup, action, and expected result visible. customStrategyWorksWithoutContextChanges uses one small scenario to prove delegation. This follows the Build Operate Check structure.

```java
// Build: inject a predictable algorithm.
Calculator calculator = new Calculator((left, right) -> new BigDecimal("42"));
// Operate.
BigDecimal result = calculator.calculate(BigDecimal.ONE, BigDecimal.TEN);
// Check.
assertEquals(new BigDecimal("42"), result);
```

### Independent and repeatable tests

Chapter 9 Unit Tests. Each test creates its own context or stateless strategy. Tests use fixed numbers and no network, files, clock, or random input. JUnit makes success automatic. This applies the fast, independent, repeatable, and self validating parts of FIRST; no claim of a complete TDD process is made.

```java
// A fresh object prevents dependence on an earlier test.
Calculator calculator = new Calculator(new AdditionStrategy());
assertThrows(NullPointerException.class,
    () -> calculator.calculate(null, BigDecimal.ONE));
```

### Small classes with one responsibility

Chapter 10 Classes. Each concrete strategy implements one arithmetic algorithm. Calculator coordinates delegation and null checks; CalculatorDemo selects strategies and presents results. Algorithm names reveal their purpose, and arithmetic classes contain no console presentation.

```java
// AdditionStrategy owns only the addition algorithm.
public BigDecimal calculate(BigDecimal left, BigDecimal right) {
    return left.add(right);
}
```

### Organizing for change

Chapter 10 Classes. DivisionStrategy was added after the original three strategies. Git history shows that Calculator, CalculationStrategy, and the three existing algorithm classes stayed unchanged. The client composition and tests were updated to select and exercise the new strategy.

```java
// New implementation; the context does not change.
public BigDecimal calculate(BigDecimal left, BigDecimal right) {
    return left.divide(right, MathContext.DECIMAL64);
}
```

### Isolating the context from concrete algorithms

Chapter 10 Classes. Calculator depends on CalculationStrategy. Its calculation method performs the same delegation for every operation. There is no if, switch, instanceof, or strategy type name in the context. Polymorphism replaces conditional algorithm selection.

```java
// Calculator knows the contract, not a concrete algorithm.
private CalculationStrategy strategy;
// After shared operand checks:
return strategy.calculate(left, right);
```

### Separate construction from use

Chapter 11 Systems. CalculatorDemo is the composition root: it constructs concrete strategies and injects them. Calculator receives a ready strategy through its constructor or setter and never creates concrete algorithms. Runtime switching replaces the reference on the same context.

```java
Calculator calculator = new Calculator(new AdditionStrategy());
calculator.setStrategy(new SubtractionStrategy());
calculator.setStrategy(new MultiplicationStrategy());
```

### Testable system boundaries through injection

Chapter 11 Systems. A small strategy contract lets a test replace arithmetic with a deterministic lambda. The context can therefore be tested independently from actual arithmetic. Manual injection is enough for this small application; a dependency injection framework would add unnecessary setup.

```java
// Any implementation of the contract can be injected.
Calculator calculator = new Calculator((left, right) -> new BigDecimal("42"));
```

## 4 Live demonstration and validation

Run CalculatorDemo.main() without arguments. The same context produces 24, 16, 80, and 5 for operands 20 and 4 as the client selects addition, subtraction, multiplication, and division. Additional examples cover decimals, negatives, repeating division, division by zero, recovery, and switching back to addition.

On 24 October 2026, Maven verify with JDK 17 passed all 30 JUnit cases with zero failures, errors, or skipped cases. Two packaged JAR runs produced identical 62-line output. The Windows launcher also compiled the production classes and completed the same demonstration. A source audit confirmed that the context contains no strategy-selection branches or concrete strategy references.

## 5 Conclusion

Strategy moves each arithmetic algorithm into an interchangeable object. Runtime switching changes behavior without replacing the Calculator or editing its delegation logic. The cost is more small classes and explicit client configuration. For a tiny calculator a direct expression would be shorter; the separate classes make the variation point and extension behavior visible for this assignment. The context is mutable and intended for sequential use.

## Repository

https://github.com/ramazanutegen583-pixel/strategy-pattern-calculator

## References

Robert C. Martin. Clean Code. 2008. Chapters 9 Unit Tests, 10 Classes, and 11 Systems. Publisher table of contents: https://www.informit.com/store/clean-code-a-handbook-of-agile-software-craftsmanship-9780132350884

Assignment 5 Strategy Pattern Instructions, including the supplied requirement to use Chapters 9, 10, and 11.
