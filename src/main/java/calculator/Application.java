package calculator;

import calculator.controller.StringCalculator;

public class Application {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        try{
            stringCalculator.run();
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


    }
}
