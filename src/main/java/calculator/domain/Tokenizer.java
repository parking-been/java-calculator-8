package calculator.domain;

import net.bytebuddy.description.ByteCodeElement;

public class Tokenizer {
    private String calculationString;
    private String delimiter;

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
            System.out.println(ele);
        }
    }
}
