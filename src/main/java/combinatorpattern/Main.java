package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer alice = new Customer(
                "Alice",
                "alicegmail.com",
                "01156261362",
                LocalDate.of(2000, 1, 23)
        );

        System.out.println("Using combinator pattern");

        ValidationResult result = isEmailValid()
                .and(isPhoneValid())
                .and(isAdult())
                .apply(alice);

        System.out.println(result);
    }
}
