import java.util.Scanner;

public class VariableInHexFormat {

    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        String input = scan.nextLine();
        int result = Integer.valueOf(input, 16);

        System.out.println(result);

    }

}
