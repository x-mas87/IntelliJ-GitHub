package org.example.calculate;

public class PositiveNumber {

    private final int value;

    public PositiveNumber(int value) {
        validate(value);
        this.value = value;
    }


    //해당하는 값(int value)이 음수면 예외 실행
    private void validate(int value) {
        if (isNegativeNumber(value)) {
            throw new IllegalArgumentException("0또는 음수를 전달할 수 없습니다.");
        }
    }

    //해당하는 값이 양수면 객체가 만들어짐
    private boolean isNegativeNumber(int value) {
        return value <= 0;
    }
    public int toInt(){
        return value;
    }
}
