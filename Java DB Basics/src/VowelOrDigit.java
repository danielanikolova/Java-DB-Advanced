import java.util.Scanner;

public class VowelOrDigit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        switch (input){
            case "a":
                System.out.println("vowel");
                break;
            case "e":
                System.out.println("vowel");
                break;
            case "o":
                System.out.println("vowel");
                break;
            case "u":
                System.out.println("vowel");
                break;
            case "i":
                System.out.println("vowel");
                break;

            case "1":
                System.out.println("digit");
                break;
            case "2":
                System.out.println("digit");
                break;
            case "3":
                System.out.println("digit");
                break;
            case "4":
                System.out.println("digit");
                break;
            case "5":
                System.out.println("digit");
                break;
            case "6":
                System.out.println("digit");
                break;
            case "7":
                System.out.println("digit");
                break;
            case "8":
                System.out.println("digit");
                break;
            case "9":
                System.out.println("digit");
                break;
            case "0":
                System.out.println("digit");
                break;
            default:
                System.out.println("other");
                break;

        }


    }

}
