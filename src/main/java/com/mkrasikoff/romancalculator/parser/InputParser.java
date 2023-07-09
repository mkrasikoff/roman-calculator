package com.mkrasikoff.romancalculator.parser;

import com.mkrasikoff.romancalculator.model.OperationDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class InputParser {

    private final String NUMBERS_RANGE_EXCEPTION = "Operands should be between 1 and 31 inclusive.";
    private final String INVALID_ROMAN_EXCEPTION = "Invalid Roman numeral.";

    public OperationDetails parse(String input) {
        String[] taskArray = input.split(" ");

        String firstOperand = taskArray[0].trim();
        String operationType = taskArray[1];
        String secondOperand = taskArray[2].trim();

        boolean isNegativeResult = firstOperand.startsWith("-") ^ secondOperand.startsWith("-");
        boolean isRoman = isValidRoman(firstOperand) && isValidRoman(secondOperand);

        OperationDetails operationDetails = new OperationDetails();
        operationDetails.setFirstOperand(handleNegativeNumbers(firstOperand));
        operationDetails.setOperationType(operationType);
        operationDetails.setSecondOperand(handleNegativeNumbers(secondOperand));
        operationDetails.setNegativeResult(isNegativeResult);
        operationDetails.setRoman(isRoman);

        validateOperationDetails(operationDetails);

        return operationDetails;
    }

    private void validateOperationDetails(OperationDetails operationDetails) {
        if (operationDetails.isRoman()) {
            validateRomanOperands(operationDetails);
        } else {
            validateDecimalOperands(operationDetails);
        }
    }

    private void validateRomanOperands(OperationDetails operationDetails) {
        if (!isValidRoman(operationDetails.getFirstOperand()) || !isValidRoman(operationDetails.getSecondOperand())) {
            throw new IllegalArgumentException(INVALID_ROMAN_EXCEPTION);
        }
    }

    private void validateDecimalOperands(OperationDetails operationDetails) {
        if (!isValidDecimal(operationDetails.getFirstOperand()) || !isValidDecimal(operationDetails.getSecondOperand())) {
            throw new IllegalArgumentException(NUMBERS_RANGE_EXCEPTION);
        }
    }

    private boolean isValidRoman(String number) {
        if (number.startsWith("-")) {
            number = number.substring(1);
        }

        List<String> validRomanNumerals = Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI");
        return validRomanNumerals.contains(number);
    }


    private boolean isValidDecimal(String number) {
        try {
            int value = Integer.parseInt(number);
            return value >= 1 && value <= 31;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    private String handleNegativeNumbers(String input) {
        if(input.startsWith("-")) {
            return input.substring(1).trim();
        }
        return input;
    }
}
