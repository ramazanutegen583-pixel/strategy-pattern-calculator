# Strategy defense notes

## Main idea

Strategy is a behavioral pattern. It puts interchangeable algorithms behind one common interface. The client selects an algorithm; the context delegates the work through that interface.

## My example

My project is a calculator. Addition, subtraction, multiplication, and division are strategies. I keep the same Calculator object and change its strategy at runtime.

## Why it helps

The context does not need an if or switch for every operation. A new strategy can implement the same interface. The client can select it without changing the context or the existing algorithms.

## UML

CalculatorDemo is the client. Calculator is the context. CalculationStrategy is the interface. Four concrete classes implement it. The context has one current strategy reference. Both test classes are also shown.

## Clean Code

Chapter 9: clear tests with independent, fixed fixtures. Chapter 10: small classes, one algorithm per strategy, and isolation from concrete algorithms. Chapter 11: the client constructs dependencies and injects them into the context.

## Disadvantages

Strategy adds small classes and client configuration. The client must choose an appropriate strategy. For a very small calculation, a direct expression is simpler. The mutable context is intended for sequential use.

## Numerical policy

BigDecimal keeps decimal addition, subtraction, and multiplication exact. Division uses DECIMAL64 rounding. Division by zero is rejected.

## Short speech

My project uses the Strategy pattern to change calculator algorithms at runtime. The client selects a strategy, and the Calculator delegates through a common interface. Each strategy owns one algorithm. I can add a new algorithm without changing the context. I tested runtime switching, decimal results, invalid requests, and division by zero.
