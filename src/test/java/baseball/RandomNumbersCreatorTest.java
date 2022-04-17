package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.helper.RandomNumbersCreator;
import baseball.helper.RandomNumbersValidator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class RandomNumbersCreatorTest {

    @Nested
    @DisplayName("RandomNumbersCreator는")
    class RandomNumbersCreator_Do {

        @Nested
        @DisplayName("makeThreeRandomNumbers()를 사용해")
        class Use_Make_Three_Random_Numbers {

            @Test
            @DisplayName("서로 다른 임의의 수 3개를 생성할 수 있다.")
            void can_Create_Three_Random_Numbers() {

                final List<Integer> randomNumbers = RandomNumbersCreator.makeThreeRandomNumbers();
                boolean result = RandomNumbersValidator.isValidRandomNumbers(randomNumbers);
                assertThat(result).isTrue();

            }

        }

    }

}
