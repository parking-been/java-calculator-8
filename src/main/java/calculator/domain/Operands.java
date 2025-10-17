package calculator.domain;

import java.util.ArrayList;

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
