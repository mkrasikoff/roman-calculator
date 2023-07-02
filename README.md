# Roman Calculator: Java Application

Java Calculator is a simple application written in Java that performs basic arithmetic operations - addition, subtraction, multiplication, and division. The calculator can handle both Roman and Arabic numerals, providing a versatile tool for number calculations.

## Features

1. **Arithmetic Operations**: Supports the basic arithmetic operations - addition, subtraction, multiplication, and division.

2. **Numerals**: Handles both Roman and Arabic numerals. The Roman numerals should be in uppercase.

3. **Operands**: Supports operands from 1 to 10 (inclusive) for both Roman and Arabic numerals.

## Project Structure

The project is divided into several packages:

1. `main.java`: Contains the main `Calculator` class to run the application.

2. `main.java.parser`: Houses the `InputParser` class which parses and validates the user input.

3. `main.java.model`: Includes the `OperationDetails` class that encapsulates the details of an operation.

4. `main.java.executor`: Contains the `CalculatorExecutor` class, responsible for executing the calculations.

5. `main.java.operation`: Contains the `OperationType` enum which represents the supported operations.

6. `main.java.converter`: Contains classes for numeral conversions - `DecimalToRomanConverter` and `RomanToDecimalConverter`.

## How to Use

To use the calculator, simply input the operation to be performed in the console in the following format:

`<number> <operation> <number>`


For example, you could enter `3 + 2` or `II * III`. The result will be displayed on the next line.

## Errors and Exceptions

If an invalid operation is inputted (such as using numbers outside the range 1-10, or using unsupported operations), the program will throw an `IllegalArgumentException` with a suitable error message.

## Future Improvements

1. Remove value restriction.

2. Migrate to Spring, Spring Shell to create a terminal application.

3. Add tests.
