import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFunctionsImplementationExample {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = random.ints(10, 1, 10)
                .boxed()
                .collect(Collectors.toList());

        Stream<Integer> stream = list.stream();

        //filter() implementation
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer % 2 == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        stream.filter(predicate)
                .forEach(System.out::println);

        //map() implementation
        //Function is a functional interface that takes two parameters, T and R,
        // and has to implement apply() where T is input and R is return type
        stream = list.stream();
        Function<Integer, Integer> function = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * 2;
            }
        };

        stream.map(function)
                .forEach(PrintWithSpaces::print);

        System.out.println();

        //reduce() implementation
        stream = list.stream();

        //A binary operator that multiplies two numbers and returns the number at the 1s place
        BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer1, Integer integer2) {
                if (integer1 == 0) {
                    return integer2 % 10;
                } else if (integer2 == 0) {
                    return integer1 % 10;
                } else {
                    int result = (integer1 * integer2);
                    while ((result % 10) == 0) {
                        result /= 10;
                    }
                    return result % 10;
                }
            }
        };

        stream = list.stream();
        System.out.println(stream.reduce(1, binaryOperator));
    }
}
