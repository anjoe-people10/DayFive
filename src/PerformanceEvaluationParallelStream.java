import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PerformanceEvaluationParallelStream {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = random.ints(10000, 1, 100)
                .boxed()
                .collect(Collectors.toList());

        //normal stream
        long startTime = System.nanoTime();
        List<Integer> normalList = list.stream()
                .filter(n -> n<50)
                .map(n -> n/2)
                .collect(Collectors.toList());
        long normalTime = System.nanoTime() - startTime;
        System.out.println("Serial Stream took " + normalTime + " nanoseconds");

        //parallel stream
        long startTimeParallel = System.nanoTime();
        List<Integer> parallelList = list.parallelStream()
                .filter(n -> n<50)
                .map(n -> n/2)
                .collect(Collectors.toList());
        long parallelTime = System.nanoTime() - startTimeParallel;
        System.out.println("Parallel Stream took " + parallelTime + " nanoseconds");
        System.out.printf("Parallel is %f times faster than Serial\n", (float)normalTime/parallelTime);
    }
}
