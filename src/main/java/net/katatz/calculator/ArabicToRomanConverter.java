package net.katatz.calculator;

import java.util.LinkedHashMap;
import java.util.Map;

public class ArabicToRomanConverter implements IDigitConverter<String, Integer> {
    private static final Map<Integer, String> romanNumerals = new LinkedHashMap<>();

    static {
        romanNumerals.put(1000, "M");
        romanNumerals.put(900, "CM");
        romanNumerals.put(500, "D");
        romanNumerals.put(400, "CD");
        romanNumerals.put(100, "C");
        romanNumerals.put(90, "XC");
        romanNumerals.put(50, "L");
        romanNumerals.put(40, "XL");
        romanNumerals.put(10, "X");
        romanNumerals.put(9, "IX");
        romanNumerals.put(5, "V");
        romanNumerals.put(4, "IV");
        romanNumerals.put(1, "I");
    }

    public String convert(Integer arabic) {
        if (arabic <= 0 || arabic >= 4000)
            throw new IllegalArgumentException("Input number must be between 1 and 3999 inclusive.");
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> entry : romanNumerals.entrySet()) {
            int value = entry.getKey();
            while (arabic >= value) {
                result.append(entry.getValue());
                arabic -= value;
            }
        }
        return result.toString();
    }
}
