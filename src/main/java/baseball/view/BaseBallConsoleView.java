package baseball.view;

public class BaseBallConsoleView {

    public void startMessage() {
        System.out.println("야구게임이 시작되었습니다.");
        System.out.println("숫자를 입력하세요.");
    }

    public void inputMessage(final String input) {
        System.out.println(input + "를 입력하셨습니다.");
    }

    public void printMessage(final String message) {
        System.out.println(message);
    }

    public void confirmMessage() {
        System.out.println("어떻게 하시겠습니까? 재시작 : 1, 종료 : 2");
    }

    public void exitMessage() {
        System.out.println("게임을 종료합니다.");
    }
}
