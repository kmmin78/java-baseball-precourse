package baseball;

import baseball.view.BaseBallGame;

public class Application {
    public static void main(String[] args) {
        final BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.start(true);
    }
}
