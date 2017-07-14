import java.util.*;

public class MostFrequentNumber {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] parsedInput = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        LinkedHashMap<Integer, Integer> numbers = new LinkedHashMap<>();

        for (int i = 0; i < parsedInput.length; i++) {

            if (!numbers.containsKey(parsedInput[i])){
                numbers.put(parsedInput[i], 1);
            }
            else {
                numbers.put(parsedInput[i], numbers.get(parsedInput[i]) + 1);
            }

        }

        int number = 0;
        int maxAccurance = Collections.max(numbers.values());

        for (Map.Entry<Integer, Integer> entry: numbers.entrySet() ) {
            if (maxAccurance == entry.getValue()){
                number = entry.getKey();
                System.out.println(number);
                return;
            }
        }


    }
}
