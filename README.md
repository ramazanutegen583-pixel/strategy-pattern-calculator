# Strategy Calculator

Assignment 5 for Software Design Patterns. Java 17, suggested Calculator topic.

Open the folder containing pom.xml as a Maven project in IntelliJ IDEA. Select JDK 17 or later, then run CalculatorDemo.main() without arguments. The shared Strategy Calculator Demo configuration is included.

On Windows, double-click run-demo.cmd. It locates a JDK, compiles the production classes, and leaves the console open.

The client creates one Calculator and replaces its CalculationStrategy at runtime. The context delegates through the interface and has no conditional selection of algorithms.

Build and run:

```shell
mvn verify
java -jar target/strategy-calculator-1.0.0.jar
```

The context validates non-null inputs. Strategies operate on BigDecimal values; addition, subtraction, and multiplication preserve decimal arithmetic.
