package org.example;

import org.example.calculate.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/*
• 요구사항
• 간단한 사칙연산을 할 수 있다.
• 양수로만 계산할 수 있다.
• 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.
• MVC패턴(Model-View-Controller) 기반으로 구현한다*/
public class CalculatorTest {

    //1+2 ----> calculator
    //3   <----
    @DisplayName("덧셈 연산을 수행한다.")
    @ParameterizedTest
    //밑에 메소드(stream)를 소스로 사용함
    @MethodSource("formulaAndResult")
    void calculateTest(int operand1, String operator, int operand2, int result) {
        //calculator에게 작업을 위엄함 계산을 해달라고 > Calculator로 이동
        int calculateResult = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        assertThat(calculateResult).isEqualTo(result);
    }
    private static Stream<Arguments> formulaAndResult(){
        return Stream.of(
                arguments(1,"+",2,3),
                arguments(1,"-",2,-1),
                arguments(4,"*",2,8),
                arguments(4,"/",2,2)
        );
    }
}
