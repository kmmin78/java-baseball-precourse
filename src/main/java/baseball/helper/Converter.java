package baseball.helper;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static List<Integer> stringToList(final String numbers) {
        if (AnswerValidator.isNotNumeric(numbers)) {
            return new ArrayList<>();
        }
        return makeNumbersList(numbers);
    }

    private static List<Integer> makeNumbersList(final String numbers) {
        final List<Integer> numbersList = new ArrayList<>();
        for (int i = 0; i < numbers.length(); i++) {
            final char number = numbers.charAt(i);
            numbersList.add(Character.getNumericValue(number));
        }
        return numbersList;
    }

}
