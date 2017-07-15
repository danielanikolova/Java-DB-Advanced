import java.util.HashMap;

import java.util.LinkedHashMap;
import java.util.Scanner;


public class StudentsByAge {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, Integer> studentInfo = new LinkedHashMap<String, Integer>();

        while (!input.endsWith("END")){

           String[] inputElements = input.split(" ");

           int age = Integer.parseInt(inputElements[2]);

           studentInfo.put(input, age);

            input = scanner.nextLine();
        }

        studentInfo.entrySet().stream()
                .filter(n->n.getValue()>=18 && n.getValue()<=24)
                .forEach(n->System.out.println(n.getKey()));

    }
}
