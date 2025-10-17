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

        String[] tokens = input.split("[,:]");
        return Arrays.stream(tokens)
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
