import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookStore {

    public static void main(String[] args) {

        Stream<Book> books = Stream.of(
                new Book("Vinetu3", 20, "Karl Mai"),
                new Book("Vinetu1", 20, "Karl Mai"),
                new Book("Vinetu2", 15, "Karl Mai"),
                new Book("Sherlock Holmes", 12, "Arthur C. Doyl"),
                new Book("The Lost World", 43, "Arthur C. Doyl"));

        Map<String, Double> collect = books.collect(Collectors.groupingBy(Book::getAuthor,
                Collectors.summingDouble(Book::getPrice)));

        collect
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry<String, Double>::getValue)
                        .reversed()
                        .thenComparing(Map.Entry<String, Double>::getKey))
                .forEach(System.out::print);


    }
}
