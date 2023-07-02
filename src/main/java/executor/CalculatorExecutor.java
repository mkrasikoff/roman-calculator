package main.java.executor;

import main.java.parser.InputParser;
import main.java.converter.DecimalToRomanConverter;
import main.java.converter.RomanToDecimalConverter;
import main.java.model.OperationDetails;
import main.java.operation.OperationType;

public class CalculatorExecutor {

    private final String NUMBER_FORMAT_EXCEPTION = "Wrong input format. Try again with another numbers.";
    private final InputParser inputParser = new InputParser();
    private final DecimalToRomanConverter decimalToRomanConverter = new DecimalToRomanConverter();
    private final RomanToDecimalConverter romanToDecimalConverter = new RomanToDecimalConverter();

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
