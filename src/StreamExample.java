import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(73, 42, 67, 92, 30, 33);

        //IMPORTANT: Once you use a stream, you can't use it again
        Stream<Integer> stream = list.stream();

        //filter
        Stream<Integer> filteredStream = stream.filter(n -> n % 2 == 0);

        //map
        Stream<Integer> mappedStream = filteredStream.map(n -> n * 2);

        //forEach
        mappedStream.forEach(n -> System.out.println(n));

        //CHAINED OPERATIONS: Takes only even numbers, doubles it, and sums them together
        int result = list.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .reduce(0, (c, e) -> c + e);

        System.out.println(result);


        //sorted()

        Stream<Integer> sortedValues = list.stream()
                                            .sorted();

        sortedValues.forEach(PrintWithSpaces::print);
    }
}
