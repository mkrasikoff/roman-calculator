# Roman Calculator: Java / Spring Shell Application

Roman Calculator is a command-line application built with Spring Shell. It performs basic arithmetic operations - addition, subtraction, multiplication, and division. The calculator can handle both Roman and Arabic numerals, providing a useful tool for number calculations.

## Features

1. **Arithmetic Operations**: Supports the basic arithmetic operations - addition, subtraction, multiplication, and division.
2. **Numerals**: Handles both Roman and Arabic numerals. The Roman numerals should be in uppercase.
3. **Operands**: Supports operands from 1 to 31 (inclusive) for Romans. We have a limitation on numbers, since there is no generally accepted designation for Roman numerals after certain values.
4. **Spring Shell Interface**: Runs as a command-line application, accepting and processing user inputs in real time.

## Project Structure

The project is organized into several packages:

1. `com.mkrasikoff.romancalculator`: Contains the main `RomanCalculatorApplication` class to run the application.
2. `com.mkrasikoff.romancalculator.parser`: Houses the `InputParser` class which parses and validates the user input.
3. `com.mkrasikoff.romancalculator.model`: Includes the `OperationDetails` class that encapsulates the details of an operation.
4. `com.mkrasikoff.romancalculator.executor`: Contains the `CalculatorExecutor` class, responsible for executing the calculations.
5. `com.mkrasikoff.romancalculator.operation`: Contains the `OperationType` enum which represents the supported operations.
6. `com.mkrasikoff.romancalculator.converter`: Contains classes for numeral conversions - `DecimalToRomanConverter` and `RomanToDecimalConverter`.
7. `com.mkrasikoff.romancalculator.shell`: Houses the Spring Shell command classes.
8. `com.mkrasikoff.romancalculator.exception`: Contains errors to throw and their messages.

## How to Use

To use the calculator, start the application. You'll be greeted with a welcome message and a prompt. Simply input the operation to be performed in the following format:

`calc "<number> <operation> <number>"`

For example, you could enter `calc "3 + 2"` or `calc "II * III"`. The result will be displayed on the next line.

## Future Improvements

1. Add more tests
2. Further customization and enhancements using Spring Shell features.
3. Fix issues: Random input 2 strings, 3 strings, 4 + strings, zero input / 0 and VVVVVVV - change exception from decimal out of range to correct exception
4. Move some exception logic from Executor to Input Parser (?)
