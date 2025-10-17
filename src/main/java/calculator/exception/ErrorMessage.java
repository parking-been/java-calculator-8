package calculator.exception;

public enum ErrorMessage {
    NULL_INPUT_ERROR("[ERROR] null은 입력할 수 없습니다."),
    CUSTOM_DELIMITER_ERROR("[ERROR] 커스텀 구분자는 `//`와 `\\n` 사이에 위치해야합니다."),
    CUSTOM_DELIMITER_ERROR_2("[ERROR] 커스텀 구분자는 한 개의 문자로 이루어져 있습니다."),
    TOKENIZER_INPUT_ERROR("[ERROR] Operand는 숫자로만 이루어져 있습니다."),
    TOKENIZER_INPUT_ERROR_2("[ERROR] Operand는 양수로만 이루어져 있습니다.");

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

}
