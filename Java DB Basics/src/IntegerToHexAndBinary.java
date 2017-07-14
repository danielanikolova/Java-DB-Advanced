import java.util.Scanner;

public class IntegerToHexAndBinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inputInteger = scan.nextInt();

        String hexValue = Integer.toHexString(inputInteger).toUpperCase();
        String binaryValue = Integer.toBinaryString(inputInteger);

        System.out.println(hexValue);
        System.out.print(binaryValue);



    }
}
