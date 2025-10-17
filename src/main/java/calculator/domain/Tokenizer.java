package calculator.domain;

import java.util.ArrayList;

import calculator.exception.ErrorMessage;
import net.bytebuddy.description.ByteCodeElement;
import org.assertj.core.error.ErrorMessageFactory;

public class Tokenizer {
    private String calculationString;
    private String delimiter;
    private ArrayList<Integer> operand = new ArrayList<>();
    public Tokenizer(String calculationString, String delimiter){
        this.calculationString = calculationString;
        this.delimiter = delimiter;
    }

    public void run(){
        checkOperand();

    }

    private void checkOperand(){

        String[] parts = calculationString.split("[" + delimiter + "\\s]+");

        for (String ele : parts){
            if(ele.matches("\\d+")){
                operand.add(Integer.parseInt(ele));
            }
            else{
                throw new IllegalArgumentException(ErrorMessage.TOKENIZER_INPUT_ERROR.getMessage());
            }
        }

    }
}
