package com.mkrasikoff.romancalculator;

import com.mkrasikoff.romancalculator.executor.CalculatorExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class RomanCalculatorApplication implements CommandLineRunner {

    @Autowired
    private CalculatorExecutor calculatorExecutor;

    public static void main(String[] args) {
        SpringApplication.run(RomanCalculatorApplication.class, args);
    }

    @Override
    public void run(String... args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Please enter an operation to perform:");
                String inputLine = scanner.nextLine();
                try {
                    System.out.println(calculate(inputLine));
                } catch (Exception e) {
                    System.err.println("Error calculating the operation: " + e.getMessage());
                }
            }
        }
    }

    private String calculate(String inputLine) {
        return calculatorExecutor.execute(inputLine);
    }
}
