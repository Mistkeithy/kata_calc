package net.katatz.calculator;

public interface IDigitDetector {
    public String detectAndConvert(String input);
    public Boolean detectNumerals(String input);
    public Short getConvertedCounter();
}
