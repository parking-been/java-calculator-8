package calculator.domain;

import calculator.exception.ErrorMessage;

/* 커스텀 구분자 확인 & 문자열 나누기 */
public class DelimiterPolicy {
    private String totalString;
    private final String CUSTOM_DELIMITER_PREFIX = "//";
    private final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private String delimiter = ",:";
    private String calculationString = null;
    private int prefixIndex;
    private int suffixIndex;

    public DelimiterPolicy(String totalString){
        this.totalString = totalString;
    }

    //커스텀 구분자 확인 & 문자열 나누기
    public void run(){
        checkPrefixSuffixIndex();
    }

    //커스텀 구분자 확인 + validation
    private void checkPrefixSuffixIndex(){
        this.prefixIndex = this.totalString.indexOf(CUSTOM_DELIMITER_PREFIX);
        this.suffixIndex = this.totalString.indexOf(CUSTOM_DELIMITER_SUFFIX);

        if (prefixIndex==-1 && suffixIndex==-1){
            //둘 다 존재하지 않는 경우
            calculationString = totalString;
        }
        else if (prefixIndex==-1 || suffixIndex==-1){
            //둘 중 하나만 존재하는 경우
            throw new IllegalArgumentException(ErrorMessage.CUSTOM_DELIMITER_ERROR.getMessage());
        }
        else{
            //둘 다 존재하는 경우
            //커스텀 구분자 확인 + validation
            checkCustomDelimiter();

        }


    }

    private void checkCustomDelimiter(){
        if (prefixIndex < suffixIndex){
            String newDelimiter = totalString.substring(prefixIndex+2,suffixIndex);
            //커스텀 구문자의 길이가 1이 아닐 경우
            if (newDelimiter.length()!=1){
                throw new IllegalArgumentException(ErrorMessage.CUSTOM_DELIMITER_ERROR_2.getMessage());
            }
            delimiter = delimiter + newDelimiter;

        }
        else{
            throw new IllegalArgumentException(ErrorMessage.CUSTOM_DELIMITER_ERROR.getMessage());
        }
    }






}
