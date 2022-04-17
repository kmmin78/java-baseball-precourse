package baseball.helper;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomNumbersCreator {
    public static List<Integer> makeThreeRandomNumbers() {
        final Set<Integer> distinctThreeNumbers = makeDistinctThreeNumbers();
        return makeListOf(distinctThreeNumbers);
    }

    private static Set<Integer> makeDistinctThreeNumbers() {
        final Set<Integer> distinctThreeNumbers = new HashSet<>();
        while (distinctThreeNumbers.size() < 3) {
            distinctThreeNumbers.add(Randoms.pickNumberInRange(1, 9));
        }
        return distinctThreeNumbers;
    }

    private static List<Integer> makeListOf(final Set<Integer> distinctThreeNumbersSet) {
        return new ArrayList<>(distinctThreeNumbersSet);
    }
}
