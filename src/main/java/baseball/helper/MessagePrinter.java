package baseball.helper;

public class MessagePrinter {

    public void startMessage() {
        System.out.println("숫자를 입력하세요.");
    }

    public void inputMessage(final String input) {
        System.out.println(input + "를 입력하셨습니다.");
    }

    public void printMessage(final String message) {
        if (message.length() > 0) {
            System.out.println(message);
        }
    }

    public void confirmMessage() {
        System.out.println("어떻게 하시겠습니까? 재시작 : 1, 종료 : 2");
    }

    public void exitMessage() {
        System.out.println("게임 종료.");
    }
}
