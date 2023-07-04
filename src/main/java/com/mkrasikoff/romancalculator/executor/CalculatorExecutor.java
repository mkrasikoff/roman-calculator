package com.mkrasikoff.romancalculator.executor;

import com.mkrasikoff.romancalculator.parser.InputParser;
import com.mkrasikoff.romancalculator.converter.DecimalToRomanConverter;
import com.mkrasikoff.romancalculator.converter.RomanToDecimalConverter;
import com.mkrasikoff.romancalculator.model.OperationDetails;
import com.mkrasikoff.romancalculator.operation.OperationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculatorExecutor {

    private final String NUMBER_FORMAT_EXCEPTION = "Wrong input format. Try again with another numbers.";

    @Autowired
    private InputParser inputParser;

    @Autowired
    private DecimalToRomanConverter decimalToRomanConverter;

    @Autowired
    private RomanToDecimalConverter romanToDecimalConverter;

    public String execute(String inputLine) {
        try {
            OperationDetails operationDetails = inputParser.parse(inputLine);

            int firstNumber;
            int secondNumber;

            if (operationDetails.isRoman()) {
                firstNumber = romanToDecimalConverter.convert(operationDetails.getFirstOperand());
                secondNumber = romanToDecimalConverter.convert(operationDetails.getSecondOperand());
            } else {
                firstNumber = Integer.parseInt(operationDetails.getFirstOperand());
                secondNumber = Integer.parseInt(operationDetails.getSecondOperand());
            }

            OperationType operationType = OperationType.fromString(operationDetails.getOperationType());
            int result = operationType.execute(firstNumber, secondNumber);

            if(operationDetails.isRoman()) {
                return decimalToRomanConverter.convert(result);
            } else {
                return Integer.toString(result);
            }
        } catch (NumberFormatException exception) {
            throw new NumberFormatException(NUMBER_FORMAT_EXCEPTION);
        }
    }
}
