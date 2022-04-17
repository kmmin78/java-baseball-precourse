package baseball.service;

import baseball.constants.AnswerResult;
import baseball.helper.AnswerValidator;
import baseball.helper.Converter;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseBallService {

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
        final Map<AnswerResult, Integer> allResult = new HashMap<>();
        for (int i = 0; i < originAnswers.size(); i++) {
            final Map<AnswerResult, Integer> result = oneByManyCompare(i, originAnswers.get(i), playerAnswers);
            mergeMap(allResult, result);
        }

        if (allResult.isEmpty()) {
            allResult.put(AnswerResult.NOTHING, 1);
        }
        return allResult;
    }

    private void mergeMap(final Map<AnswerResult, Integer> allResult, final Map<AnswerResult, Integer> result) {
        result.forEach((k, v) -> allResult.merge(k, v, Integer::sum));
    }

    private Map<AnswerResult, Integer> oneByManyCompare(final int originIndex, final Integer originAnswer,
                                                        final List<Integer> playerAnswers) {
        final Map<AnswerResult, Integer> result = new HashMap<>();

        for (int playerIndex = 0; playerIndex < playerAnswers.size(); playerIndex++) {
            final AnswerResult answerResult = oneByOneCompare(originIndex, originAnswer, playerIndex,
                    playerAnswers.get(playerIndex));
            putIfStrikeOrBall(result, answerResult);
        }

        return result;
    }

    private AnswerResult oneByOneCompare(final int originIndex, final Integer originAnswer,
                                         final int playerIndex, final Integer playerAnswer) {
        if (originAnswer.equals(playerAnswer)
                && originIndex == playerIndex) {
            return AnswerResult.STRIKE;
        }
        if (originAnswer.equals(playerAnswer)) {
            return AnswerResult.BALL;
        }

        return AnswerResult.NOTMATCH;
    }

    private void putIfStrikeOrBall(final Map<AnswerResult, Integer> result, final AnswerResult answerResult) {
        if (answerResult == AnswerResult.BALL) {
            result.put(answerResult, 1);
        }
        if (answerResult == AnswerResult.STRIKE) {
            result.put(answerResult, 1);
        }
    }

}
