package baseball.helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnswerValidator {

    public static void validateAnswer(final String answer) {
        if (isNotNumeric(answer)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        if (isNotThreeLength(answer)) {
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }
        if (isNotAllZero(answer)) {
            throw new IllegalArgumentException("입력한 수에 0이 포함될 수 없습니다.");
        }
        if (isNotAllDistinctNumbers(answer)) {
            throw new IllegalArgumentException("각 숫자는 서로 달라야 합니다.");
        }
    }

    private static boolean isNotThreeLength(final String answer) {
        return answer.length() != 3;
    }

    protected static boolean isNotNumeric(final String numbers) {
        final Set<Boolean> isDigitResults = new HashSet<>();
        for (int i = 0; i < numbers.length(); i++) {
            final char number = numbers.charAt(i);
            isDigitResults.add(Character.isDigit(number));
        }
        return isDigitResults.contains(false);
    }

    private static boolean isNotAllZero(final String numbers) {
        final Set<Boolean> results = new HashSet<>();
        for (int i = 0; i < numbers.length(); i++) {
            final char number = numbers.charAt(i);
            results.add(isNotZero(Character.getNumericValue(number)));
        }
        return results.contains(false);
    }

    private static boolean isNotZero(final Integer number) {
        return number != 0;
    }

    private static boolean isNotAllDistinctNumbers(final String answer) {
        final List<Integer> answers = makeNumbersList(answer);
        final Set<Integer> distinctNumbers = new HashSet<>(answers);
        return distinctNumbers.size() != 3;
    }

    private static List<Integer> makeNumbersList(final String answer) {
        final List<Integer> numbersList = new ArrayList<>();
        for (int i = 0; i < answer.length(); i++) {
            final char number = answer.charAt(i);
            numbersList.add(Character.getNumericValue(number));
        }
        return numbersList;
    }

}
