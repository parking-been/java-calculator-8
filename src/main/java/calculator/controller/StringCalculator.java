package calculator.controller;

import calculator.domain.DelimiterPolicy;
import calculator.domain.Tokenizer;
import calculator.domain.Operands;
import calculator.view.InputView;
import calculator.view.OutputView;

public class StringCalculator {

    public void run(){
        OutputView.printInputMessage();
        String totalString = InputView.getInput();

        if (totalString.isBlank()){
            OutputView.printOutputExceptionMessage();
        }
        else {

            DelimiterPolicy delimiterPolicy = new DelimiterPolicy(totalString);
            //커스텀 구분자 확인 & 문자열 나누기
            delimiterPolicy.run();

            Tokenizer tokenizer = new Tokenizer(delimiterPolicy.getCalculationString(), delimiterPolicy.getDelimiter());
            //각 부분을 숫자로 변환 & validation
            tokenizer.run();

            // 숫자 부분을 모두 합하고 출력하기
            Operands operands = tokenizer.getOperands();
            OutputView.printOutputMessage();
            System.out.println(operands.add());
        }


    }


}
