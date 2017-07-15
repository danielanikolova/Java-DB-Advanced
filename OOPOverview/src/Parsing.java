import java.util.DoubleSummaryStatistics;
import java.util.Scanner;

/**
 * Created by danie on 7/4/2017.
 */
public class Parsing {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double num = Double.parseDouble(scanner.nextLine());

        double result = num*num;

        System.out.printf("%f", result);


    }
}
