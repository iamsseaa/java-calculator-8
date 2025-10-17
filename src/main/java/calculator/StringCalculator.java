package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_DELIMITERS = "[,:]";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        String numbers = input;
        String delimiter = DEFAULT_DELIMITERS;

        if (matcher.matches()) {
            delimiter = matcher.group(1);
            numbers = matcher.group(2);
        }

        String[] tokens = numbers.split(delimiter);

        int sum = 0;
        for (String token : tokens) {
            validateNumber(token);
            sum += Integer.parseInt(token);
        }

        return sum;
    }

    private static void validateNumber(String token) {
        try {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new InvalidInputException("음수는 입력할 수 없습니다 : " + number);
            }
        } catch (NumberFormatException e) {
            throw new InvalidInputException("잘못된 숫자 형식입니다: " + token);
        }
    }
}
