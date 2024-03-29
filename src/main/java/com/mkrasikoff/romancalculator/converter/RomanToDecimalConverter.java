package com.mkrasikoff.romancalculator.converter;

import com.mkrasikoff.romancalculator.exception.ErrorMessages;
import com.mkrasikoff.romancalculator.exception.InvalidRomanNumberException;
import org.springframework.stereotype.Component;

@Component
public class RomanToDecimalConverter {

    public int convert(String str) {
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            int s1 = romanValueConverter(str.charAt(i));

            if (i + 1 < str.length()) {
                int s2 = romanValueConverter(str.charAt(i + 1));

                if (s1 >= s2) {
                    result += s1;
                }
                else {
                    result += s2 - s1;
                    i++;
                }
            }
            else {
                result += s1;
            }
        }
        return result;
    }

    private int romanValueConverter(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            default:
                throw new InvalidRomanNumberException(ErrorMessages.MESSAGE_INVALID_ROMAN_NUMBER_EXCEPTION + ch);
        }
    }
}
