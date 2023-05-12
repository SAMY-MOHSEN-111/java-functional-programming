package functionalinerface;

import java.util.List;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        String phoneNumber = "01156261362";
        System.out.println(isValidPhoneNumber(phoneNumber));
        System.out.println(isValidNumberPredicate.and(containsNumber3).test(phoneNumber));
    }

    static boolean isValidPhoneNumber(String phoneNumber) {
        List<String> prefixes = List.of("010", "011", "012", "015");
        boolean hasPrefix = prefixes.contains(phoneNumber.substring(0, 3));
        return hasPrefix && phoneNumber.length() == 11;
    }

    static Predicate<String> isValidNumberPredicate = phoneNumber -> {
        List<String> prefixes = List.of("010", "011", "012", "015");
        boolean hasPrefix = prefixes.contains(phoneNumber.substring(0, 3));
        return hasPrefix && phoneNumber.length() == 11;
    };

    static Predicate<String> containsNumber3 = number -> number.contains("3");
}
