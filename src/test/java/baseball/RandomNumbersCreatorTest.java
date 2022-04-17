package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.helper.RandomNumbersCreator;
import baseball.helper.RandomNumbersValidator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumbersCreatorTest {

    @Test
    @DisplayName("RandomNumbersCreator는 서로 다른 임의의 수 3개를 생성할 수 있다")
    void random_number_creation_test() {
        final List<Integer> randomNumbers = RandomNumbersCreator.makeThreeRandomNumbers();
        boolean result = RandomNumbersValidator.isValidRandomNumbers(randomNumbers);
        assertThat(result).isTrue();
    }

}
