package com.mkrasikoff.romancalculator.shell;

import com.mkrasikoff.romancalculator.executor.CalculatorExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class CalculatorCommands {

    @Autowired
    private CalculatorExecutor calculatorExecutor;

    @ShellMethod(value = "Calculate a numeral expression.", key = "calc")
    public String calculate(String expression) {
        try {
            return calculatorExecutor.execute(expression);
        } catch (Exception e) {
            return "Error calculating the operation: " + e.getMessage();
        }
    }
}
