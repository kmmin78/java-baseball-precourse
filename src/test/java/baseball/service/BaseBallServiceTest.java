package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.constants.AnswerResult;
import baseball.helper.Converter;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BaseBallServiceTest {

    private BaseBallService baseBallService = new BaseBallService();

    @Nested
    @DisplayName("BaseBallService는")
    class BaseBallService_Do {

        @Nested
        @DisplayName("compareAnswer()를 사용해")
        class Use_Compare_Answer {

            private List<Integer> originAnswers;
            private List<Integer> playerAnswers;

            @Test
            @DisplayName("랜덤생성된 숫자가 627, 입력한 숫자가 467일 경우 1 STRIKE 1 BALL을 Map으로 반환한다.")
            void is_627_467() {
                originAnswers = Converter.stringToList("627");
                playerAnswers = Converter.stringToList("467");

                final Map<AnswerResult, Integer> result = baseBallService.compareAnswer(originAnswers, playerAnswers);
                assertThat(result.get(AnswerResult.STRIKE)).isEqualTo(1);
                assertThat(result.get(AnswerResult.BALL)).isEqualTo(1);
            }

            @Test
            @DisplayName("랜덤생성된 숫자가 194, 입력한 숫자가 195일 경우 2 STRIKE을 Map으로 반환한다.")
            void is_194_195() {
                originAnswers = Converter.stringToList("194");
                playerAnswers = Converter.stringToList("195");

                final Map<AnswerResult, Integer> result = baseBallService.compareAnswer(originAnswers, playerAnswers);
                assertThat(result.get(AnswerResult.STRIKE)).isEqualTo(2);
            }

            @Test
            @DisplayName("랜덤생성된 숫자가 273, 입력한 숫자가 273일 경우 3 STRIKE을 Map으로 반환한다.")
            void is_273_273() {
                originAnswers = Converter.stringToList("273");
                playerAnswers = Converter.stringToList("273");

                final Map<AnswerResult, Integer> result = baseBallService.compareAnswer(originAnswers, playerAnswers);
                assertThat(result.get(AnswerResult.STRIKE)).isEqualTo(3);
            }

            @Test
            @DisplayName("랜덤생성된 숫자가 193, 입력한 숫자가 276일 경우 NOTHING을 Map으로 반환한다.")
            void is_193_276() {
                originAnswers = Converter.stringToList("193");
                playerAnswers = Converter.stringToList("276");

                final Map<AnswerResult, Integer> result = baseBallService.compareAnswer(originAnswers, playerAnswers);
                assertThat(result.get(AnswerResult.NOTHING)).isEqualTo(1);
            }

        }

    }

}