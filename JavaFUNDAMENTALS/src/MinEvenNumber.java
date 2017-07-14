import java.util.*;

public class MinEvenNumber {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<String> intStr = Arrays.asList(scan.nextLine().split(" "));

        if (intStr.get(0).equals("")){
            System.out.println("No match");
            return;
        }
        else {

            OptionalDouble result = intStr.stream()
                    .mapToDouble(Double::valueOf)
                    .filter(i -> i % 2 == 0)
                    .min();

            if (result.isPresent()) {
                System.out.print(result.getAsDouble());
            } else {
                System.out.println("No match");
            }
        }
    }

}
