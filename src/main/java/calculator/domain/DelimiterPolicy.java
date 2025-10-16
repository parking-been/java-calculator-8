package calculator.domain;

/* 커스텀 구분자 확인 & 문자열 나누기 */
public class DelimiterPolicy {
    private String totalString;
    private final String CUSTOM_DELIMITER_PREFIX = "//";
    private final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private String delimiter;
    private String calculationString = null;

    public DelimiterPolicy(String totalString){
        this.totalString = totalString;
    }

    //커스텀 구분자 확인 & 문자열 나누기
    public void run(){
        checkCustomDelimiter();
    }

    //커스텀 구분자 확인 + validation
    private void checkCustomDelimiter(){
        int prefixIndex = this.totalString.indexOf(CUSTOM_DELIMITER_PREFIX);
        int suffixIndex = this.totalString.indexOf(CUSTOM_DELIMITER_SUFFIX);

        if (prefixIndex==-1 && suffixIndex==-1){
            //둘다 존재하지 않는 경우
            calculationString = totalString;
        }
        else if (prefixIndex==-1 || suffixIndex==-1){
            //둘중 하나만 존재하는 경우

        }
        else{
            //둘다 존재하는 경우

        }




    }






}
