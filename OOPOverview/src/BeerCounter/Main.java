package BeerCounter;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            try {
                int[] beers = Arrays.stream(input.split("\\s"))
                        .mapToInt(a -> Integer.parseInt(a)).toArray();
                BeerCounter.buyBeer(beers[0]);
                BeerCounter.drinkBeer(beers[1]);
                input = scanner.nextLine();
            }
            catch (Exception e) {
                break;
            }

        }
        System.out.printf("%d %d\n", BeerCounter.beerInStock, BeerCounter.beersDrankCount);


    }
}
