# Validation results

Date: **24 October 2026**. Runtime: **Microsoft JDK 17.0.20.1** on Windows.

## Automated tests

Command: `mvn -B verify`.

Result: **30 test cases, 0 failures, 0 errors, 0 skipped; BUILD SUCCESS**.

- CalculatorTest: 8 cases covering runtime replacement, injected custom algorithms, missing strategies and operands, state preservation after an invalid replacement, and switching after an algorithm rejects an operation.
- StrategyTest: 22 cases covering all four arithmetic variants, positive/negative/decimal/zero operands, exact decimal addition, stateless reuse, three zero divisor representations, and recurring-division precision.

The 30 executed cases include parameterized runs. This differs from the number of declared Java test methods in UML.

## Execution checks

- The packaged JAR was executed twice; output was identical and both runs exited with code 0.
- The demonstration printed 62 lines and ten verified results: 24, 0.3, 16, -10, 80, 0.9375, 5, 0.3333333333333333, 3, 24.
- The zero-divisor example was rejected as expected and the demonstration continued.
- `run-demo.cmd --no-pause` located a JDK, compiled all production sources, and produced the same demonstration without Maven.

See [the actual transcript](demo-output.txt) and [machine-readable execution results](validation-results.json).

## Pattern and documentation checks

- Calculator contains no algorithm-selection branches or concrete strategy references.
- The demo creates exactly one Calculator and switches its current strategy.
- The division extension leaves the Context, interface, and original strategies unchanged.
- The JDK tree API extracted all authored Java declarations. The inventory and complete UML include all fields, methods, parameter types, return types, constructors, and local declarations.
- The Word report was rendered and every page visually reviewed. The report image is the same complete UML image committed to docs.

The shared IntelliJ application configuration is included. The terminal checks establish JDK compilation, JAR execution, and Windows launcher behavior; no claim of an IntelliJ UI test is made.
