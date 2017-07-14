import java.util.Scanner;

public class FitStringIn20Chars {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String inputString = scan.nextLine();
        String newString = null;
        if (inputString.length()<20){

            int repetition = 20-inputString.length();

            newString = inputString;

            for (int i = 0; i < repetition; i++) {
                newString+="*";
            }

            System.out.print(newString);
        }
        else if(inputString.length()>20){
            newString = inputString.substring(0,20);
            System.out.print(newString);
        }else{
            System.out.print(inputString);
        }
    }

}

