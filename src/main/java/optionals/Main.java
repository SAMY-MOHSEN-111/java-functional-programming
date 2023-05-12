package optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional.ofNullable("Hello world")
                        .ifPresent(System.out::println);


    }
}
