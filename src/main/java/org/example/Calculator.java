package org.example;

public class Calculator {
    public static int calculate(int operand1, String operator, int operand2) {
        //ArithmeticOperator 라는 enum에게 다시 작업을 위임함, 결과값을 ArithmeticOperator로 부터 받으면 다시 test로 토스함
        return ArithmeticOperator.calculate(operand1, operator, operand2);

        /*if ("+".equals(operator)) {
            return operand1 + operand2;
        } else if ("-".equals(operator)) {
            return operand1 - operand2;
        } else if ("*".equals(operator)) {
            return operand1 * operand2;
        } else if ("/".equals(operator)) {
            return operand1 / operand2;
        }
        return 0;*/

    }
}