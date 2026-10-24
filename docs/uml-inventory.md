# Complete source declaration inventory

All authored application and test Java types are included. External library types and generated lambda implementation classes are excluded.

| Type | Kind | Fields | Methods | Explicit constructors |
| --- | --- | ---: | ---: | ---: |
| AdditionStrategy | class | 0 | 1 | 0 |
| CalculationStrategy | interface | 0 | 1 | 0 |
| DivisionStrategy | class | 0 | 1 | 0 |
| MultiplicationStrategy | class | 0 | 1 | 0 |
| SubtractionStrategy | class | 0 | 1 | 0 |
| CalculatorDemo | class | 0 | 2 | 1 |
| Calculator | class | 1 | 2 | 1 |
| CalculatorTest | class | 0 | 8 | 0 |
| StrategyTest | class | 0 | 6 | 0 |

## AdditionStrategy

Source: `src/main/java/edu/aitu/strategy/algorithm/AdditionStrategy.java`

- `+ calculate(left: BigDecimal, right: BigDecimal): BigDecimal`

## CalculationStrategy

Source: `src/main/java/edu/aitu/strategy/algorithm/CalculationStrategy.java`

- `+ calculate(left: BigDecimal, right: BigDecimal): BigDecimal`

## DivisionStrategy

Source: `src/main/java/edu/aitu/strategy/algorithm/DivisionStrategy.java`

- `+ calculate(left: BigDecimal, right: BigDecimal): BigDecimal`

## MultiplicationStrategy

Source: `src/main/java/edu/aitu/strategy/algorithm/MultiplicationStrategy.java`

- `+ calculate(left: BigDecimal, right: BigDecimal): BigDecimal`

## SubtractionStrategy

Source: `src/main/java/edu/aitu/strategy/algorithm/SubtractionStrategy.java`

- `+ calculate(left: BigDecimal, right: BigDecimal): BigDecimal`

## CalculatorDemo

Source: `src/main/java/edu/aitu/strategy/client/CalculatorDemo.java`

- `- CalculatorDemo()`
- `+ main(args: String[]): void` (static)
- `- showCalculation(calculator: Calculator, operation: String, left: String, right: String): void` (static)
- Locals in `main`: `calculator: Calculator` (line 20), `exception: ArithmeticException` (line 45)
- Locals in `showCalculation`: `result: BigDecimal` (line 59)

## Calculator

Source: `src/main/java/edu/aitu/strategy/context/Calculator.java`

- `- strategy: CalculationStrategy`
- `+ Calculator(strategy: CalculationStrategy)`
- `+ setStrategy(strategy: CalculationStrategy): void`
- `+ calculate(left: BigDecimal, right: BigDecimal): BigDecimal`

## CalculatorTest

Source: `src/test/java/edu/aitu/strategy/CalculatorTest.java`

- `~ constructorRejectsMissingStrategy(): void`
- `~ sameContextSwitchesAlgorithmsAtRuntime(): void`
- `~ customStrategyWorksWithoutContextChanges(): void`
- `~ rejectedReplacementPreservesPreviousStrategy(): void`
- `~ missingLeftOperandIsRejected(): void`
- `~ missingRightOperandIsRejected(): void`
- `~ switchingBackRestoresOriginalAlgorithm(): void`
- `~ contextCanSwitchAfterAnAlgorithmRejectsAnOperation(): void`
- Locals in `sameContextSwitchesAlgorithmsAtRuntime`: `calculator: Calculator` (line 21), `left: BigDecimal` (line 22), `right: BigDecimal` (line 23)
- Locals in `customStrategyWorksWithoutContextChanges`: `calculator: Calculator` (line 34), `left: inferred` (line 34), `right: inferred` (line 34), `result: BigDecimal` (line 36)
- Locals in `rejectedReplacementPreservesPreviousStrategy`: `calculator: Calculator` (line 43)
- Locals in `missingLeftOperandIsRejected`: `calculator: Calculator` (line 52)
- Locals in `missingRightOperandIsRejected`: `calculator: Calculator` (line 58)
- Locals in `switchingBackRestoresOriginalAlgorithm`: `calculator: Calculator` (line 64), `result: BigDecimal` (line 68)
- Locals in `contextCanSwitchAfterAnAlgorithmRejectsAnOperation`: `calculator: Calculator` (line 75), `result: BigDecimal` (line 80)

## StrategyTest

Source: `src/test/java/edu/aitu/strategy/StrategyTest.java`

- `~ strategiesProduceExpectedNumbers(strategy: CalculationStrategy, left: String, right: String, expected: String): void`
- `~ calculationCases(): Stream<Arguments>` (static)
- `~ decimalAdditionIsExact(): void`
- `~ algorithmInstanceDoesNotStorePreviousResults(): void`
- `~ divisionRejectsZeroInEveryRepresentation(zero: String): void`
- `~ recurringDivisionUsesTheDocumentedPrecision(): void`
- Locals in `strategiesProduceExpectedNumbers`: `result: BigDecimal` (line 22)
- Locals in `decimalAdditionIsExact`: `strategy: CalculationStrategy` (line 50), `result: BigDecimal` (line 52)
- Locals in `algorithmInstanceDoesNotStorePreviousResults`: `strategy: CalculationStrategy` (line 59), `result: BigDecimal` (line 62)
- Locals in `divisionRejectsZeroInEveryRepresentation`: `strategy: CalculationStrategy` (line 70)
- Locals in `recurringDivisionUsesTheDocumentedPrecision`: `strategy: CalculationStrategy` (line 77), `result: BigDecimal` (line 79)
