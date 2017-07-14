import java.util.*;

public class FindAndSumInt {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<String> input = Arrays.asList(scan.nextLine().split("\\s+"));

        OptionalInt sum = input.stream()
                .filter(x -> isNumber(x))
                .mapToInt(Integer::valueOf)
                .reduce((a,b) -> a+b);


        if (sum.isPresent()){
            System.out.println(sum.getAsInt());
        }
        else {
            System.out.println("No match");
        }


    }

    private static boolean isNumber(String x) {
        boolean result = true;

        try {
            Integer num = Integer.parseInt(x);
            result = true;
        }catch (NumberFormatException ex ){
            result = false;
        }
        return result;
    }

}
