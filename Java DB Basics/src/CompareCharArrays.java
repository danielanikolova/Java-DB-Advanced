import java.util.Scanner;

public class CompareCharArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[] input1 = scan.nextLine().replace(" ", "").toCharArray();
        char[] input2 = scan.nextLine().replaceAll(" ", "").toCharArray();

        int minLen = Math.min(input1.length, input2.length);

        for (int i = 0; i < minLen ; i++) {

            if (input1[i] < input2[i]){
                for (int j = 0; j < input1.length; j++) {
                    System.out.print(input1[j]);
                }
                System.out.println();
                for (int m = 0; m < input2.length ; m++) {
                    System.out.print(input2[m]);
                }
                return;
            }
            else if (input2[i] < input1[i]){
                for (int j = 0; j <input2.length ; j++) {
                    System.out.print(input2[j]);
                }

                System.out.println();

                for (int j = 0; j <input1.length ; j++) {
                    System.out.print(input1[j]);
                }
                return;

            }

        }
        if (input1.length<input2.length){
            for (int j = 0; j <input1.length ; j++) {
                System.out.print(input1[j]);
            }

            System.out.println();
            for (int j = 0; j <input2.length ; j++) {
                System.out.print(input2[j]);
            }
        }else {

            for (int j = 0; j <input2.length ; j++) {
                System.out.print(input2[j]);
            }
            System.out.println();
            for (int j = 0; j <input1.length ; j++) {
                System.out.print(input1[j]);
            }

        }


    }
}
