package calculator.domain;

import java.util.ArrayList;

import calculator.exception.ErrorMessage;

public class Tokenizer {
    private String calculationString;
    private String delimiter;
    private ArrayList<Integer> operand = new ArrayList<>();
    private Operands operands;
    public Tokenizer(String calculationString, String delimiter){
        this.calculationString = calculationString;
        this.delimiter = delimiter;
    }

    public void run(){
        checkOperand();
        operands = new Operands(operand);


    }

    public Operands getOperands(){
        return operands;
    }

    private void checkOperand(){

        String[] parts = calculationString.split("[" + delimiter + "]+");

        for (String ele : parts){
            if(ele.matches("(-)?\\d+")){
                int element = Integer.parseInt(ele.trim());
                
                if (element <= 0){
                    throw new IllegalArgumentException(ErrorMessage.TOKENIZER_INPUT_ERROR_2.getMessage());
                }

                operand.add(element);
            }
            else{
                throw new IllegalArgumentException(ErrorMessage.TOKENIZER_INPUT_ERROR.getMessage());
            }
        }

    }
}
