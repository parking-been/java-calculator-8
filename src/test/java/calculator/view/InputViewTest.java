package calculator.view;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest extends NsTest{

    @Test
    void 입력_확인용(){
        run("6");
        assertThat(output()).isEqualTo("6");
    }

//    @Test
//    void 입력_예외_처리_확인용(){
//        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()->run(""));
//        assertThat(e.getMessage()).contains("  ");
//    }

    @Override
    protected void runMain() {
        System.out.println(InputView.getInput());   // 테스트할 메서드 실행
    }
}