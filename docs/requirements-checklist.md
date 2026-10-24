# Assignment 5 requirements checklist

The implementation uses the assignment's suggested **Option B Calculator**.

| Requirement | Evidence |
| --- | --- |
| Java 17 | Maven compiler release 17; JDK 17 compilation and execution |
| Common Strategy interface | CalculationStrategy declares calculate(BigDecimal, BigDecimal) |
| At least three algorithms | AdditionStrategy, SubtractionStrategy, MultiplicationStrategy, DivisionStrategy |
| Context holds a strategy reference | Calculator.strategy has interface type |
| Runtime replacement | setStrategy changes the current reference on the same Calculator |
| No selection branches in Context | Calculator contains no if, switch, instanceof, ternary, or concrete strategy names |
| Client selects and configures strategies | CalculatorDemo is the composition root |
| Extensibility | Division added in a separate commit without modifying Context, interface, or original strategies |
| At least five Clean Code applications | Seven annotated examples from Chapters 9, 10, and 11 in the report |
| Chapter 9 | Readable tests and independent, repeatable fixtures |
| Chapter 10 | Focused responsibilities, organizing for change, isolation from concrete classes |
| Chapter 11 | Separate construction from use; injection supports isolated context testing |
| UML | All authored classes/interface, all fields/methods/explicit constructors, types, visibility, and relationships |
| Required short reflection | reports/strategy-pattern-report.md |
| Report introduction | Domain and interchangeable algorithm family explained |
| Report conclusion | Flexibility versus extra classes and configuration reflected on |
| GitHub link | Included in both report versions and README |
| Incremental commits | Base algorithms, extension, then verified documentation |
| Live demonstration | No-argument main with runtime switching and visible results |

Moodle submission and the in-class defense must be performed by the student according to the course schedule.
