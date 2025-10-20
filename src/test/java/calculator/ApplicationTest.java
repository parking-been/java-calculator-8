package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_사용_2() {
        assertSimpleTest(() -> {
            run("//;\\n1;3;4:5");
            assertThat(output()).contains("결과 : 13");
        });
    }

    @Test
    void 커스텀_구분자_미사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 빈_문자열_전달_시() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 기존_커스텀_문자도_추가_가능() {
        assertSimpleTest(() -> {
            run("//:\\n1:3:4:5");
            assertThat(output()).contains("결과 : 13");
        });
    }

    @Test
    void 숫자_사이_여러개의_구분자_사용_가능() {
        assertSimpleTest(() -> {
            run("1:,:2,,:3");
            assertThat(output()).contains("결과 : 6");
        });
    }


    //예외 case test

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_사이사이_띄어쓰기_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1 :,  :2 , ,: 3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분_문자열이_하나만_사용된_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1:2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 지정되지_않은_커스텀_문자_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1+2+3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자열에_0_사용된_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//+\\n1+0+3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자열에_음수_사용된_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-2,3:4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분문자가_없는_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
