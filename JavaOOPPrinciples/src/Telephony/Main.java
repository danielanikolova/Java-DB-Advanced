package Telephony;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String [] phoneNumbers = scanner.nextLine().split(" ");
        String [] url = scanner.nextLine().split(" ");

        String number = null;
        String site = null;

        Smartphone phone = new Smartphone(number,site);

        for (int i = 0; i < phoneNumbers.length; i++) {

            number = phoneNumbers[i];

            phone.callOther(number);

        }

        for (int i = 0; i < url.length ; i++) {
            site = url[i];
            phone.browseWorldWide(site);

        }

    }

}
