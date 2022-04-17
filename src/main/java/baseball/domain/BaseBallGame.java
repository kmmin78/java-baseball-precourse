package baseball.domain;

import baseball.constants.AnswerResult;
import baseball.constants.GameState;
import baseball.controller.BaseBallController;
import baseball.helper.RandomNumbersCreator;
import baseball.view.BaseBallConsoleView;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;

public class BaseBallGame {

    private final BaseBallController baseBallController;
    private final BaseBallConsoleView baseBallConsoleView;
    private List<Integer> randomNumbers;

    public BaseBallGame() {
        this.baseBallController = new BaseBallController();
        this.baseBallConsoleView = new BaseBallConsoleView();
    }

    private void initRandomNumbers() {
        this.randomNumbers = RandomNumbersCreator.makeThreeRandomNumbers();
    }

    public void start(final boolean initFlag) {

        if (initFlag) {
            initRandomNumbers();
        }

        baseBallConsoleView.startMessage();
        final String answer = baseBallController.getPlayerInput();
        baseBallConsoleView.inputMessage(answer);

        //1. 정답을 검증한다.
        validateAnswer(answer);

        //2. 정답을 다루기 쉬운 자료구조(List)로 변환한다.
        final List<Integer> answers = convertAnswer(answer);

        //3. 정답을 비교한다.
        final Map<AnswerResult, Integer> allResult = compareAnswer(randomNumbers, answers);

        //4. 결과를 통해 컴퓨터의 다음 행동을 결정한다.
        decideNextAction(allResult);
    }

    private void validateAnswer(final String answer) {
        try {
            baseBallController.validateAnswer(answer);
        } catch (IllegalArgumentException e) {
            final String errorMessage = e.getMessage();
            baseBallConsoleView.printMessage(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private List<Integer> convertAnswer(final String answer) {
        return baseBallController.convertAnswer(answer);
    }

    private Map<AnswerResult, Integer> compareAnswer(final List<Integer> originAnswers,
                                                     final List<Integer> playerAnswers) {
        return baseBallController.compareAnswer(originAnswers, playerAnswers);
    }

    private void decideNextAction(final Map<AnswerResult, Integer> allResult) {
        if (allResult.containsKey(AnswerResult.NOTHING)) {
            baseBallConsoleView.printMessage("낫싱");
            start(false);
            return;
        }
        final StringBuilder builder = new StringBuilder();
        Integer strikeCount = 0;
        if (allResult.containsKey(AnswerResult.BALL)) {
            builder.append(allResult.get(AnswerResult.BALL) + "볼 ");
        }
        if (allResult.containsKey(AnswerResult.STRIKE)) {
            strikeCount = allResult.get(AnswerResult.STRIKE);
            builder.append(strikeCount + "스트라이크");
        }
        baseBallConsoleView.printMessage(builder.toString());

        if (strikeCount == 3) {
            restartOrExit();
            return;
        }
        start(false);
    }

    private void restartOrExit() {
        baseBallConsoleView.confirmMessage();
        final String answer = Console.readLine();
        if (GameState.START.getState().equals(answer)) {
            start(true);
            return;
        }
        if (GameState.END.getState().equals(answer)) {
            exit();
        }
    }

    private void exit() {
        baseBallConsoleView.exitMessage();
    }

}
