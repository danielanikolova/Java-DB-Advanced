import java.util.*;

public class StudentsByFirstLastName2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<String> names = new ArrayList<>();

        while (!input.equals("END")){

            String [] namesAsArray = input.split(" ");

                String firstName = namesAsArray[0];
                String secondName = namesAsArray[1];


            if (firstName.compareTo(secondName)<0){
                names.add(input);
            }


            input = scanner.nextLine();
        }

        names.stream().forEach(n-> System.out.println(n));

    }
}
