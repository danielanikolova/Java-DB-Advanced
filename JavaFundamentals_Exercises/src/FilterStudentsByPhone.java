import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FilterStudentsByPhone {
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
            String phoneNumber = info[2];

            students.put(name, phoneNumber);

        }
        students.entrySet()
                .stream()
                .filter(a->a.getValue().startsWith("02") || a.getValue().startsWith("+3592"))
                .forEach(a-> System.out.println(a.getKey()));

    }
}
