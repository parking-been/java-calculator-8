package calculator.view;

public class OutputView {
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String OUTPUT_EXCEPTION_0_MESSAGE = "결과 : 0";
    private static final String OUTPUT_MESSAGE = "결과 : ";
    public static void printInputMessage(){
        System.out.println(INPUT_MESSAGE);
    }

    public static void printOutputExceptionMessage(){
        System.out.println(OUTPUT_EXCEPTION_0_MESSAGE);
    }

    public static void printOutputMessage(){
        System.out.print(OUTPUT_MESSAGE);
    }

}
