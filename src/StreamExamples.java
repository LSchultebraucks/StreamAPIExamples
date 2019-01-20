import java.util.Arrays;
import java.util.List;

public class StreamExamples {
    public static void main(String[] args) {
        StreamExamples.filter();
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

    private static void map() {

    }
}

