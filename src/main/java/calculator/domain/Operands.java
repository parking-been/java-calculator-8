package calculator.domain;

import java.util.ArrayList;

/**
 * 문자열에서 추출한 숫자 저장 및 계산
 */
public class Operands {
    private ArrayList<Integer> operand = new ArrayList<>();

    public Operands(ArrayList<Integer> operand){
        this.operand = operand;
    }

    public int add(){
        return operand.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

}
