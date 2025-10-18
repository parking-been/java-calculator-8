package calculator.view;
import java.util.NoSuchElementException;
import camp.nextstep.edu.missionutils.Console;

import calculator.exception.ErrorMessage;
public class InputView {
    public static String getInput(){

        String value = "";
        try {
            value = Console.readLine();
        } catch (NoSuchElementException e){
            value = "";
        }


        //validation
        if (value == null){
            throw new IllegalArgumentException(ErrorMessage.NULL_INPUT_ERROR.getMessage());
        }

        return value.trim();
    }
}
