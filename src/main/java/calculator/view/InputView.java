package calculator.view;

import camp.nextstep.edu.missionutils.Console;

import calculator.exception.ErrorMessage;
public class InputView {
    public static String getInput(){

        String value =Console.readLine();

        //validation
        if (value == null){
            throw new IllegalArgumentException(ErrorMessage.NULL_INPUT_ERROR.getMessage());
        }

        return value.trim();
    }
}
