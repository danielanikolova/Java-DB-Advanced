import java.util.*;
import java.util.stream.Collectors;

public class BoundedNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::valueOf)
                .filter(x->Collections.min(nums)<= x && Collections.max(nums)>=x)
                .collect(Collectors.toList());

        for (int number:numbers) {
            System.out.printf(number + " ");
        }


    }
}
