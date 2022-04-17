package baseball.view;

import baseball.constants.AnswerResult;
import baseball.constants.GameState;
import baseball.controller.BaseBallController;
import baseball.helper.MessagePrinter;
import baseball.helper.RandomNumbersCreator;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;

public class BaseBallGame {

    private final BaseBallController baseBallController;
    private final MessagePrinter messagePrinter;
    private List<Integer> randomNumbers;

    public BaseBallGame() {
        this.baseBallController = new BaseBallController();
        this.messagePrinter = new MessagePrinter();
    }

    private void initRandomNumbers() {
        this.randomNumbers = RandomNumbersCreator.makeThreeRandomNumbers();
    }

    public void start(final boolean initFlag) {
        if (initFlag) {
            initRandomNumbers();
        }
        messagePrinter.startMessage();
        final String answer = baseBallController.getPlayerInput();
        messagePrinter.inputMessage(answer);
        validateAnswer(answer);
        final List<Integer> answers = convertAnswer(answer);
        final Map<AnswerResult, Integer> allResult = compareAnswer(randomNumbers, answers);
        decideNextAction(allResult);
    }

    private void validateAnswer(final String answer) {
        try {
            baseBallController.validateAnswer(answer);
        } catch (IllegalArgumentException e) {
            final String errorMessage = e.getMessage();
            messagePrinter.printMessage(errorMessage);
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
            messagePrinter.printMessage("낫싱");
        }
        Integer strikeCount = printStrikeAndBallMessageAndReturnStrikeCount(allResult);
        if (strikeCount == 3) {
            restartOrExit();
            return;
        }
        start(false);
    }

    private Integer printStrikeAndBallMessageAndReturnStrikeCount(final Map<AnswerResult, Integer> allResult) {
        final StringBuilder builder = new StringBuilder();
        Integer strikeCount = 0;
        if (allResult.containsKey(AnswerResult.BALL)) {
            builder.append(allResult.get(AnswerResult.BALL)).append("볼 ");
        }
        if (allResult.containsKey(AnswerResult.STRIKE)) {
            strikeCount = allResult.get(AnswerResult.STRIKE);
            builder.append(strikeCount).append("스트라이크");
        }
        messagePrinter.printMessage(builder.toString());
        return strikeCount;
    }

    private void restartOrExit() {
        messagePrinter.confirmMessage();
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
        messagePrinter.exitMessage();
    }

}
