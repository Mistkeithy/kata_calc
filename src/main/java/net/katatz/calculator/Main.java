package net.katatz.calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        IExpressionProcessor calculator = new ExpressionProcessor();

        String result = calculator.calc(input.nextLine());
        System.out.println(result);
    }
}