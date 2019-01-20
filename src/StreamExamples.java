import java.util.Arrays;
import java.util.List;

public class StreamExamples {
    public static void main(String[] args) {
        StreamExamples.filter();
        StreamExamples.filterWithMethod();
        StreamExamples.map();
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

        // As Streams
        numbers.stream()
                .map(number -> number * number)
                .forEach(System.out::println);
    }


}

