import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExamples {
    public static void main(String[] args) {
        StreamExamples.filter();
        StreamExamples.filterWithMethod();
        StreamExamples.map();
        StreamExamples.sum();
        StreamExamples.flatMap();
        StreamExamples.collect();
    }


    private static void filter() {
        List<String> words = Arrays.asList("Abra", "Kadrabra", "Aloha");

        // Before
        for (String word : words) {
            if (word.startsWith("A")) {
                System.out.println(word);
            }
        }

        // As Streams
        words.stream()
                .filter(word -> word.startsWith("A"))
                .forEach(System.out::println); // syntactic sugar for .forEach(word -> System.out.println(word));
    }

    private static void filterWithMethod() {
        List<String> words = Arrays.asList("Abra", "Kadrabra", "Aloha");

        // As Streams with calling a method in filter
        words.stream()
                .filter(StreamExamples::startsWithA)
                .forEach(System.out::println); // syntactic sugar for .forEach(word -> System.out.println(word));
    }

    private static boolean startsWithA(String word) {
        return word.startsWith("A");
    }

    private static void map() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Before
        for (Integer number : numbers) {
            int squaredNumber = number * number;
            System.out.println(squaredNumber);
        }

        // As Stream
        numbers.stream()
                .map(number -> number * number)
                .forEach(System.out::println);
    }

    private static void sum() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Before
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);

        // As Stream
        System.out.println(numbers.stream().mapToInt(Integer::intValue).sum());
    }

    private static void flatMap() {
        List<List<Integer>> matrix = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));

        // Before
        int sum = 0;
        for (List<Integer> row : matrix) {
            for (Integer value : row) {
                sum += value;
            }
        }
        System.out.println(sum);

        // With flatMap Stream
        System.out.println(matrix.stream().flatMap(Collection::stream).mapToInt(Integer::intValue).sum());
    }

    private static void collect() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> oddNumbers = numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());

        oddNumbers.forEach(System.out::println);
    }
}

