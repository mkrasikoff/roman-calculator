package main.java.converter;

public class DecimalToRomanConverter {

    private static final String[] ROMAN_NUMERALS = new String[] { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C" };
    private static final int[] INTEGER_NUMERALS = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100 };

    public String convert(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        int times;

        if(num == 0) {
            return "0";
        }

        if(num < 0) {
            stringBuilder.append("-");
            num = -num;
        }

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
