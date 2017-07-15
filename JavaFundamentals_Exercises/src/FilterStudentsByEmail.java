import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FilterStudentsByEmail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> students = new LinkedHashMap<>();

        while (true){
            String line= scanner.nextLine();

            if (line.equals("END")){
                break;
            }
            String[] info = line.split("\\s");
            String name = info[0] + " " + info[1];
            String email = info[2];

            students.put(name, email);

        }

        students.entrySet()
                .stream()
                .filter(a->a.getValue().endsWith("@gmail.com"))
                .forEach(a-> System.out.println(a.getKey()));

    }

}
