package com.mkrasikoff.romancalculator.converter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RomanToDecimalConverterTest {

    private RomanToDecimalConverter converter = new RomanToDecimalConverter();

    @ParameterizedTest
    @CsvSource({
            "I, 1",
            "IV, 4",
            "IX, 9",
            "X, 10"
    })
    public void convert_romanToDecimal_successfully(String input, int expected) {
        assertEquals(expected, converter.convert(input));
    }

    @Test
    public void convert_invalidRoman_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> converter.convert("P"));
    }
}
