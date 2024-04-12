import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectStreamExample {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = random.ints(10, 1, 10)
                .boxed().collect(Collectors.toList());

        Set<Character> linkedHashSet = random.ints(10, (int) 'a', (int) 'z' + 1)
                .mapToObj(n -> (char) n)
                .collect(Collectors.toSet());

        System.out.println(linkedHashSet);


        //This conversion is done because primitive streams are only available for Int, Long and Double
        //So to convert an IntStream to a Stream of characters, we cannot use
        random.ints(10, (int) 'a', (int) 'z' + 1)
                .mapToObj(n -> (char) n)
                .forEach(System.out::println);
    }
}
