package net.katatz.calculator;

public class RomanDetector implements IDigitDetector {

    private short convertedCounter = 0;

    public Boolean detectNumerals(String input) {
        // Check if the input string contains Roman numerals
        String romanPattern = "(?i)^.*[IVXLCDM].*$"; // Case-insensitive
        return input.matches(romanPattern);
    }

    public String detectAndConvert(String input) {
        if (detectNumerals(input)) {
            // If Roman numerals are detected, send to the converter
            IDigitConverter<Integer, String> romantoarabicconverter = new RomanToArabicConverter();
            // Set instance is detected for roman values
            this.convertedCounter++;
            return String.valueOf(romantoarabicconverter.convert(input));
        } else {
            // If Arabic numerals are detected, return the same value
            return input;
        }
    }

    public Short getConvertedCounter() {
        return convertedCounter;
    }
}
