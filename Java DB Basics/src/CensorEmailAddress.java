import java.util.Scanner;

public class CensorEmailAddress {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String email = scan.nextLine();
        String text = scan.nextLine();

        String [] usernameAndDomain = email.split("@");
        String username = usernameAndDomain[0];
        String domain = usernameAndDomain[1];

        String replacement = username.replaceAll("(?s).", "*") + "@" + domain;

        String outputText = text.replaceAll(email, replacement);

        System.out.print(outputText);
    }

}
