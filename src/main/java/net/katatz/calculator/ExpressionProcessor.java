package net.katatz.calculator;

public class ExpressionProcessor implements IExpressionProcessor{
    public String calc(String expression) {
        try {
            IDigitDetector romandetector = new RomanDetector();
            String[] tokens = expression.split(" ");

            if (tokens.length != 3) {
                throw new IllegalArgumentException("Invalid expression. Please provide a valid expression in the format 'operand operator operand'.");
            }

            int operand1 = Integer.parseInt(romandetector.detectAndConvert(tokens[0]));
            int operand2 = Integer.parseInt(romandetector.detectAndConvert(tokens[2]));
            if ((operand1 <= 0 || operand1 > 10) || (operand2 <= 0 || operand2 > 10))
                throw new IllegalArgumentException("Input number must be between 1 (I) and 10 (X) inclusive.");

            if (romandetector.getConvertedCounter() == 1)
                throw new IllegalArgumentException("One of these operands contain the roman numbers");

            char operator = tokens[1].charAt(0);

            int result = 0;

            switch (operator) {
                case '+':
                    result = operand1 + operand2;
                    break;
                case '-':
                    result = operand1 - operand2;
                    break;
                case '*':
                    result = operand1 * operand2;
                    break;
                case '/':
                    if (operand2 == 0) {
                        throw new ArithmeticException("Division by zero is not allowed.");
                    }
                    result = operand1 / operand2;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operator. Supported operators are +, -, *, /");
            }

            if (romandetector.getConvertedCounter() != 0) {
                IDigitConverter<String, Integer> arabictoromanconverter = new ArabicToRomanConverter();
                return arabictoromanconverter.convert(result);
            }
            return Integer.toString(result);

        } catch (NumberFormatException e) {
            return "Invalid input. Please provide valid numeric operands.";
        } catch (IllegalArgumentException | ArithmeticException e) {
            return e.getMessage();
        }
    }
}
