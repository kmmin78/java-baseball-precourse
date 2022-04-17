package baseball.domain;

import baseball.constants.GameState;
import baseball.controller.BaseBallController;
import baseball.helper.RandomNumbersCreator;
import baseball.view.BaseBallConsoleView;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseBallGame {

    private final BaseBallController baseBallController;
    private final BaseBallConsoleView baseBallConsoleView;
    private final List<Integer> randomNumbers;

    public BaseBallGame() {
        this.baseBallController = new BaseBallController();
        this.baseBallConsoleView = new BaseBallConsoleView();
        this.randomNumbers = RandomNumbersCreator.makeThreeRandomNumbers();
    }

    public void start() {

        baseBallConsoleView.startMessage();
        final String answer = baseBallController.getPlayerInput();
        baseBallConsoleView.inputMessage(answer);

        //1. 정답을 검증한다.
        validateAnswer(answer);

        //2. 정답을 다루기 쉬운 자료구조(List)로 변환한다.
        final List<Integer> answers = convertAnswer(answer);

        //3. 정답을 비교한다.
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

    private void restartOrExit(final String message) {
        baseBallConsoleView.printMessage(message);
        baseBallConsoleView.confirmMessage();
        final String answer = Console.readLine();
        if (GameState.valueOf(answer) == GameState.START) {
            start();
        }
        if (GameState.valueOf(answer) == GameState.END) {
            exit();
        }
    }

    private void exit() {
        baseBallConsoleView.exitMessage();
        System.exit(0);
    }

}
