package com.mkrasikoff.romancalculator.converter;

import org.springframework.stereotype.Component;

@Component
public class DecimalToRomanConverter {

    private static final String[] ROMAN_NUMERALS = new String[] { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
    private static final int[] INTEGER_NUMERALS = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };

    public String convert(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        int times;

        for (int i = INTEGER_NUMERALS.length - 1; i >= 0; i--) {
            times = num / INTEGER_NUMERALS[i];
            num %= INTEGER_NUMERALS[i];

            while (times > 0) {
                stringBuilder.append(ROMAN_NUMERALS[i]);
                times--;
            }
        }

        return stringBuilder.toString();
    }
}
