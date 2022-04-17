package baseball.controller;

import baseball.constants.AnswerResult;
import baseball.helper.AnswerValidator;
import baseball.helper.Converter;
import baseball.service.BaseBallService;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;

public class BaseBallController {

    private final BaseBallService baseBallService;

    public BaseBallController() {
        this.baseBallService = new BaseBallService();
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

    public Map<AnswerResult, Integer> compareAnswer(final List<Integer> originAnswers,
                                                    final List<Integer> playerAnswers) {
        return baseBallService.compareAnswer(originAnswers, playerAnswers);
    }

}
