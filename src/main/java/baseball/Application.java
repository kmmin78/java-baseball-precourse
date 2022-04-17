package baseball;

import baseball.helper.AnswerValidator;
import baseball.helper.RandomNumbersCreator;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final List<Integer> randomNumbers = RandomNumbersCreator.makeThreeRandomNumbers();

        System.out.println("야구게임 시작");
        System.out.println("숫자를 입력하세요.");
        final String answer = Console.readLine();
        System.out.println(answer + "를 입력하셨습니다.");

        AnswerValidator.validateAnswer(answer);

    }
}
