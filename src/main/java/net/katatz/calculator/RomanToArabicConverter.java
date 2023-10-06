package net.katatz.calculator;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanToArabicConverter implements IDigitConverter<Integer, String> {

    private static final Map<Character, Integer> romanNumerals = new LinkedHashMap<>();

    static {
        romanNumerals.put('I', 1);
        romanNumerals.put('V', 5);
        romanNumerals.put('X', 10);
        romanNumerals.put('L', 50);
        romanNumerals.put('C', 100);
        romanNumerals.put('D', 500);
        romanNumerals.put('M', 1000);
    }

    public Integer convert(String roman) {
        int result = 0;
        int prevValue = 0;
        for (int i = roman.length() - 1; i >= 0; i--) { //get
            char currentChar = roman.charAt(i);
            int currentValue = romanNumerals.get(currentChar);
            result += (currentValue < prevValue) ? -currentValue : currentValue;
            prevValue = currentValue;
        }

        if (result <= 0 || result >= 4000)
            throw new IllegalArgumentException("Input number must be between I and MMMM inclusive.");

        return result;
    }
}
