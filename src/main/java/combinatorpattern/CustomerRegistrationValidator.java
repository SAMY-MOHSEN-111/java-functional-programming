package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;

import static combinatorpattern.CustomerRegistrationValidator.*;
import static combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult> {


    static CustomerRegistrationValidator isEmailValid() {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        System.out.println("email");
        return customer -> Pattern.matches(emailRegex, customer.getEmail()) ? SUCCESS : EMAIL_NOT_VALID;
    }

    static CustomerRegistrationValidator isPhoneValid() {
        List<String> phonePrefixes = List.of("010", "011", "012", "015");
        System.out.println("phone");
        return customer -> {
            String phoneNumber = customer.getPhoneNumber();
            return phoneNumber.length() == 11 &&
                    phonePrefixes.contains(phoneNumber.substring(0, 3))
                    ? SUCCESS : PHONE_NUMBER_NOT_VALID;
        };
    }

    static CustomerRegistrationValidator isAdult() {
        System.out.println("adult");
        return customer -> Period.between(customer.getDateOfBirth(), LocalDate.now()).getYears() >= 16
                ? SUCCESS : IS_NOT_AN_ADULT;
    }

    default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }
}
