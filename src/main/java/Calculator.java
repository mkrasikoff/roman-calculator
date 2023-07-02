package main.java;

import main.java.executor.CalculatorExecutor;
import java.util.Scanner;

public class Calculator {

    private final CalculatorExecutor calculatorExecutor = new CalculatorExecutor();

    public String calculate(String inputLine) {
        return calculatorExecutor.execute(inputLine);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Calculator calculator = new Calculator();

            while (true) {
                System.out.println("Please enter an operation to perform:");
                String inputLine = scanner.nextLine();
                try {
                    System.out.println(calculator.calculate(inputLine));
                } catch (Exception e) {
                    System.err.println("Error calculating the operation: " + e.getMessage());
                }
            }
        }
    }
}
