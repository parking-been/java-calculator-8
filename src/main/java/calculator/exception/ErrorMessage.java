package calculator.exception;

public enum ErrorMessage {
    NULL_INPUT_ERROR("null은 입력할 수 없습니다."),
    CUSTOM_DELIMITER_ERROR("커스텀 구분자는 `//`와 `\\n` 사이에 위치해야합니다.");

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

}
