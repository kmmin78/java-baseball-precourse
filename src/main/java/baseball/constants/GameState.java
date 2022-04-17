package baseball.constants;

public enum GameState {
    START("1"), END("2");

    private String state;

    GameState(String state) {
        this.state = state;
    }
}
