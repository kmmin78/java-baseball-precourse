package baseball.controller;

import baseball.constants.AnswerResult;
import baseball.service.BaseBallService;
import java.util.List;
import java.util.Map;

public class BaseBallController {

    private final BaseBallService baseBallService;

    public BaseBallController() {
        this.baseBallService = new BaseBallService();
    }

    public String getPlayerInput() {
        return baseBallService.getPlayerInput();
    }

    public void validateAnswer(final String answer) throws IllegalArgumentException {
        baseBallService.validateAnswer(answer);
    }

    public List<Integer> convertAnswer(final String answer) {
        return baseBallService.convertAnswer(answer);
    }

    public Map<AnswerResult, Integer> compareAnswer(final List<Integer> originAnswers,
                                                    final List<Integer> playerAnswers) {
        return baseBallService.compareAnswer(originAnswers, playerAnswers);
    }

}
