package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.helper.AnswerValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


public class AnswerValidatorTest {

    @Nested
    @DisplayName("AnswerValidator는")
    class AnswerValidator_Do {

        @Nested
        @DisplayName("isValidFormat()를 사용해")
        class Use_Is_Valid_Number {

            @Test
            @DisplayName("숫자가 아닌 값을 인자로 받은 경우 IllegalArgumentException을 반환한다.")
            void when_Arguments_Is_Not_Number_Then_Throw_IllegalArgumentException() {

                assertSimpleTest(() ->
                        assertThatThrownBy(() -> AnswerValidator.validateAnswer("NAN"))
                                .isInstanceOf(IllegalArgumentException.class)
                );

            }

        }

    }
}
