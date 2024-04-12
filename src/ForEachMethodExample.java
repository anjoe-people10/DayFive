import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEachMethodExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 10, 9, 14, 2, 3);
        list.forEach(n -> System.out.println(n));

        /*implementation of forEach
        Takes an Object of a Consumer type,
        which is a function interface*/

        //Verbose Consumer object
        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer n) {
                System.out.println(n);
            }
        };

        list.forEach(consumer);
    }
}
