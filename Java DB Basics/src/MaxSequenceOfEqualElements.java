import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] parsedInput = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer:: parseInt)
                .toArray();

        int len = 1;
        int bestLen = 1;
        int start = 0;
        int bestStart = 0;

        for (int i = 0; i < parsedInput.length -1 ; i++) {

            if (parsedInput[i + 1] == parsedInput [i]){
               len ++;

               if (len > bestLen){
                   bestLen = len;
                   bestStart = start;
               }
            }
            else{
                start = i + 1;
                len = 1;
            }

        }
        for (int i = bestStart; i < bestStart + bestLen; i++) {

            System.out.print(parsedInput[i] + " ");

        }


    }
}
