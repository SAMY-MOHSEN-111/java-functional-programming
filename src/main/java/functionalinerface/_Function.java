package functionalinerface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int increment1 = incrementByOne(1);
        System.out.println(increment1);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);
        int multiply = multiplyBy10Function.apply(increment2);
        System.out.println(multiply);

        Function<Integer, Integer> increment1ThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);
        Integer applied = increment1ThenMultiplyBy10.apply(3);
        System.out.println(applied);

        Integer res = incrementByOneAndMultiplyBiFunction.apply(1, 10);
        System.out.println(res);
    }

    static int incrementByOne(int number) {
        return number + 1;
    }

    static int incrementByOneAndMultiply(int number, int multiplyBy) {
        return (number + 1) * multiplyBy;
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;
    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction = (number, multiplyBy) -> (number + 1) * multiplyBy;
}
