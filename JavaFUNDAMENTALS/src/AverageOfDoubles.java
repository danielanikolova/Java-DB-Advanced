import java.util.*;
import java.util.stream.DoubleStream;


public class AverageOfDoubles {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        List<String> doubles = Arrays.asList(scanner.nextLine().split(" "));


        OptionalDouble avg = doubles.stream()
                .mapToDouble(s-> Double.parseDouble(s)).average();

        if (avg.isPresent()){
            System.out.printf("%.2f",avg.getAsDouble());
        }else {
            System.out.print("No match");
        }
    }
}
