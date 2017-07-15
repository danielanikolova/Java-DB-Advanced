import java.util.ArrayList;
import java.util.Scanner;


public class StudentsByFirstLastName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayList<String> names = new ArrayList<>();

        while (!input.equals("END")){

            names.add(input);

            input = scanner.nextLine();
        }

       names.stream()
               .filter(a->{
                   String firstName = a.split(" ")[0];
                   String secondName = a.split(" ")[1];
                    boolean toPrint = false;
                   if (firstName.compareTo(secondName)<0){
                       toPrint = true;
                   }
                   else toPrint = false;

                   return toPrint;
               })
               .forEach(k-> System.out.println(k));


    }

}
