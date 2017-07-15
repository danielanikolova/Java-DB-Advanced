package LastDigitName;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();

        LastDigitName.Number inputNumber = new LastDigitName.Number(number);

        String digitName = inputNumber.findsLastDigitName(number);

        System.out.print(digitName);

    }


}
