import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class FirstName {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<String> names = Arrays.asList(scan.nextLine().split(" "));

        char letter = scan.next().toLowerCase().charAt(0);


        Optional<String> first = names.stream()
                .filter(n -> n.toLowerCase().charAt(0) == letter)
                .sorted().findFirst();

            if (first.isPresent()){
                System.out.println(first.get());
            }else {
                System.out.println("No match");
            }
    }
}
