package baseball.helper;

import static java.util.Objects.isNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomNumbersValidator {

    public static boolean isValidRandomNumbers(final List<Integer> randomNumbers) {

        if (isNull(randomNumbers)) {
            return false;
        }

        if (isNotThreeLength(randomNumbers)) {
            return false;
        }

        if (isNotAllRangeFromOneToNine(randomNumbers)) {
            return false;
        }

        if (isNotAllDistinctNumbers(randomNumbers)) {
            return false;
        }

        return true;
    }

    private static boolean isNotThreeLength(final List<Integer> randomNumbers) {
        return randomNumbers.size() != 3;
    }

    private static boolean isNotAllRangeFromOneToNine(final List<Integer> randomNumbers) {
        final Set<Boolean> results = new HashSet<>();
        for (final Integer number : randomNumbers) {
            results.add(isRangeFromOneToNine(number));
        }
        return results.contains(false);
    }

    private static boolean isRangeFromOneToNine(final Integer randomNumber) {
        if (randomNumber < 1) {
            return false;
        }
        return randomNumber <= 9;
    }

    private static boolean isNotAllDistinctNumbers(final List<Integer> randomNumbers) {
        final Set<Integer> distinctNumbers = new HashSet<>(randomNumbers);
        return distinctNumbers.size() != 3;
    }

}
