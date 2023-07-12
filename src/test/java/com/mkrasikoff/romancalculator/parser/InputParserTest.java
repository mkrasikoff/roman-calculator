package com.mkrasikoff.romancalculator.parser;

import com.mkrasikoff.romancalculator.exception.NumbersOutOfRangeException;
import com.mkrasikoff.romancalculator.model.OperationDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputParserTest {

    private final InputParser parser = new InputParser();
    private OperationDetails expected;

    @BeforeEach
    void setUp() {
        expected = new OperationDetails();
    }

    @Test
    public void parse_correctRomanIsGiven_successfully() {
        String input = "V * IV";
        expected.setFirstOperand("V");
        expected.setOperationType("*");
        expected.setSecondOperand("IV");
        expected.setRoman(true);
        expected.setNegativeResult(false);

        OperationDetails result = parser.parse(input);

        assertOperationDetails(expected, result);
    }

    @Test
    public void parse_incorrectRomanIsGiven_isNegativeResultTrue() {
        String input = "V * -IV";
        expected.setFirstOperand("V");
        expected.setOperationType("*");
        expected.setSecondOperand("IV");
        expected.setRoman(true);
        expected.setNegativeResult(true);

        OperationDetails result = parser.parse(input);

        assertOperationDetails(expected, result);
    }

    @Test
    public void parse_correctDecimalIsGiven_successfully() {
        String input = "5 * 4";
        expected.setFirstOperand("5");
        expected.setOperationType("*");
        expected.setSecondOperand("4");
        expected.setRoman(false);
        expected.setNegativeResult(false);

        OperationDetails result = parser.parse(input);

        assertOperationDetails(expected, result);
    }

    @Test
    public void parse_outOfRangePositiveDecimalIsGiven_numbersOutOfRangeExceptionIsThrown() {
        String input = "2147483648 + 1";

        assertThrows(NumbersOutOfRangeException.class, () -> parser.parse(input));
    }

    @Test
    public void parse_outOfRangeNegativeDecimalIsGiven_numbersOutOfRangeExceptionIsThrown() {
        String input = "-2147483648 - 1";

        assertThrows(NumbersOutOfRangeException.class, () -> parser.parse(input));
    }

    @Test
    public void parse_mixedNumeralsIsGiven_numberFormatExceptionIsThrown() {
        String input = "V * 4";

        assertThrows(NumberFormatException.class, () -> parser.parse(input));
    }

    @Test
    public void parse_invalidOperationIsGiven_noExceptionInInputParser() {
        String input = "V $ IV";
        expected.setFirstOperand("V");
        expected.setOperationType("$");
        expected.setSecondOperand("IV");
        expected.setRoman(true);
        expected.setNegativeResult(false);

        OperationDetails result = parser.parse(input);

        assertOperationDetails(expected, result);
    }

    private void assertOperationDetails(OperationDetails expected, OperationDetails actual) {
        assertEquals(expected.getFirstOperand(), actual.getFirstOperand());
        assertEquals(expected.getOperationType(), actual.getOperationType());
        assertEquals(expected.getSecondOperand(), actual.getSecondOperand());
        assertEquals(expected.isNegativeResult(), actual.isNegativeResult());
        assertEquals(expected.isRoman(), actual.isRoman());
    }
}
