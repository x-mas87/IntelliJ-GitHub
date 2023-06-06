package org.example;

import java.util.Arrays;

public enum ArithmeticOperator {
    ADDTION("+") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    },
    SUBTRACTION("-") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    },
    MULTIPLICATION("*") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    },
    DIVISION("/") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 / operand2;
        }
    };

    private final String operator;

    ArithmeticOperator(String operator) {
        this.operator = operator;
    }

    public abstract int arithmeticCalculate(final int operand1, final int operand2);

    //외부에 노출되는 public 인터페이스, 최종적으로 연산자에 일치하는 enum 값을 가져오고 그 enum값에 일치하는 arithmeticCalculate
    //들 중에 하나를 실행 해주고 결과값을 int로 리턴해주는 구조
    public static int calculate(int operand1, String operator, int operand2) {
        //해당 지역변수를 가지고 메소드 호출가능
        ArithmeticOperator arithmeticOperator = Arrays.stream(values())
                //v.operator = 해당enum값의 operator( +,-,*,/)가 연산자와 같다면
                .filter(v -> v.operator.equals(operator))
                //같은것을 가져오고
                .findFirst()
                //아무것도 일치하는 연산자가 없다면 ~
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다"));
        // 지역변수에 위 정수형 가상 메소드를 호출하는데, 인자에 다가 규약이 두개인 피연산자를 전달하도록 한다
        return arithmeticOperator.arithmeticCalculate(operand1, operand2);
    }
}
