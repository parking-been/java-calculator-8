package calculator.controller;

import calculator.domain.DelimiterPolicy;
import calculator.exception.ErrorMessage;
import calculator.view.InputView;
import calculator.view.OutputView;

public class StringCalculator {

    public void run(){
        OutputView.printInputMessage();
        String totalString = InputView.getInput();

        if (totalString.isBlank()){
            OutputView.printOutputExceptionMessage();
        }

        DelimiterPolicy delimiterPolicy = new DelimiterPolicy(totalString);

    }


}
