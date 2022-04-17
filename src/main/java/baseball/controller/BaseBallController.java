package baseball.controller;

import baseball.helper.AnswerValidator;
import baseball.helper.Converter;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseBallController {

    public BaseBallController() {

    }

    public String getPlayerInput() {
        return Console.readLine();
    }

    public void validateAnswer(final String answer) throws IllegalArgumentException {
        AnswerValidator.validateAnswer(answer);
    }

    public List<Integer> convertAnswer(final String answer) {
        return Converter.stringToList(answer);
    }

}
