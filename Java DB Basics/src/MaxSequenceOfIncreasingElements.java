import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfIncreasingElements {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] parsedInput = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int bestLan = 1;
        int bestStart = 0;
        int len = 1;
        int start = 0;

        for (int i = 1; i <parsedInput.length ; i++) {
            if (parsedInput[i] > parsedInput[i-1]){
                len++;

                if (len > bestLan){
                    bestLan = len;
                    bestStart = start;
                }
            }
            else{
                len = 1;
                start = i;
            }

        }

        for (int i = bestStart; i < bestStart + bestLan ; i++) {
            System.out.print(parsedInput[i] + " ");
        }

    }
}
