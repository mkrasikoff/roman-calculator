package com.mkrasikoff.romancalculator.converter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecimalToRomanConverterTest {

    private DecimalToRomanConverter converter = new DecimalToRomanConverter();

    @ParameterizedTest
    @CsvSource({
            "1, I",
            "4, IV",
            "9, IX",
            "1000, M"
    })
    public void convert_positiveDecimalToRoman_successfully(int input, String expected) {
        assertEquals(expected, converter.convert(input));
    }
}
