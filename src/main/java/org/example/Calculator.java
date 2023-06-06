package org.example;

import org.example.calculate.*;

import java.util.List;

public class Calculator {
    //of 안에있는 각각의 구현체들을 상위 인터페이스인 NewarithmeticOperator를 통해서 받는다
    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(),
            new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());
    
    
    //들어온 operator에 맞는 구현체를 찾은다음에
    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {



        //ArithmeticOperator 라는 enum에게 다시 작업을 위임함, 결과값을 ArithmeticOperator로 부터 받으면 다시 test로 토스함
        return arithmeticOperators.stream()
                //이 operator에 해당하는 실제 구현체를 필터링해서
                .filter(arithmeticOperator -> arithmeticOperator.supports(operator))
                //선택받은 operator에 해당 calculate 작업을 위임함(인자로 받은 1,2를 전달)
                //map 사용 이유 : interface에서 받는 값이 int이기 때문에
                .map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))
                .findFirst()
                //만약에 찾지 못하면
                .orElseThrow(()-> new IllegalArgumentException  ("올바른 사칙연산이 아닙니다"));

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