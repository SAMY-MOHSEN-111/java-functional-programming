//package combinatorpattern;
//
//import java.time.LocalDate;
//import java.time.Period;
//import java.util.List;
//import java.util.regex.Pattern;
//
//public class CustomerValidatorService {
//    private boolean isEmailValid(String email) {
//        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
//        return Pattern.matches(emailRegex, email);
//    }
//
//    private boolean isPhoneNumberValid(String phoneNumber) {
//        List<String> prefixes = List.of("010", "011", "012", "015");
//        boolean matchPrefix = prefixes.contains(phoneNumber.substring(0, 3));
//        return matchPrefix && phoneNumber.length() == 11;
//    }
//
//    private boolean isAdult(LocalDate dob) {
//        return Period.between(dob, LocalDate.now()).getYears() >= 16;
//    }
//
//    public boolean isValid(Customer customer) {
//        return isEmailValid(customer.getEmail())
//                && isPhoneNumberValid(customer.getPhoneNumber())
//                && isAdult(customer.getDateOfBirth());
//    }
//}
