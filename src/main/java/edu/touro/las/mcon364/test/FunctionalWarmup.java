package edu.touro.las.mcon364.test;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalWarmup {

    /**
     * Problem 1
     * Return a Supplier that gives the current month number (1-12).
     */
    public static Supplier<Integer> currentMonthSupplier() {
        Supplier <Integer> currentMonth = () -> LocalDate.now().getMonthValue();
        return currentMonth;
    }

    /**
     * Problem 2
     * Return a Predicate that is true only when the input string
     * has more than 5 characters.
     */
    public static Predicate<String> longerThanFive() {
        Predicate<String> longer = n -> n.length() > 5;
        return longer;
    }

    /**
     * Problem 3
     * Return a Predicate that checks whether a number is both:
     * - positive
     * - even
     *
     * Prefer chaining smaller predicates.
     */
    public static Predicate<Integer> positiveAndEven() {
        Predicate<Integer> isPositive = n -> n > 0;
        Predicate<Integer> isEven = n -> n % 2 == 0;
        return isPositive.and(isEven);
    }

    /**
     * Problem 4
     * Return a Function that counts words in a string.
     *
     * Notes:
     * - Trim first.
     * - Blank strings should return 0.
     * - Words are separated by one or more spaces (use can use regex "\\s+")
     *
     */
    public static Function<String, Integer> wordCounter() {
        return str -> {
            if (str == null) return 0;
            str = str.trim();
            int count = 0;

            for (int i = 0; i < str.length(); i++) {
                if (str.contains(" ")) {
                    count++;
                }
            }

            return count + 1;
        };
    }

    /**
     * Problem 5
     * Process the input labels as follows:
     * - remove blank strings
     * - trim whitespace
     * - convert to uppercase
     * - return the final list in the same relative order
     *
     * Example:
     * ["  math ", "", " java", "  "] -> ["MATH", "JAVA"]
     */
    public static List<String> cleanLabels(List<String> labels) {
        labels.removeIf(label -> label.contains(" "));
        labels.removeIf(label -> label.contains(null));
        for (String label : labels) {
            label = label.trim();
            label = label.toUpperCase();
        }
        return labels;
    }
}
