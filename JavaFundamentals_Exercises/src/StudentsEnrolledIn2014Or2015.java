import java.util.*;

public class StudentsEnrolledIn2014Or2015 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> students = new LinkedHashMap<>();

        String line = scanner.nextLine();

        while (!line.equals("END")){

            String[] data = line.split(" ");

            String studentNumber = data[0];
            String grades = data[1]+" "+data[2] +" "+ data[3]+" " + data[4];

            students.put(studentNumber, grades);

            line=scanner.nextLine();
        }

        students.entrySet()
                .stream()
                .filter(b->b.getKey().endsWith("14")||b.getKey().endsWith("15"))
                .forEach(a-> System.out.println(a.getValue()));
    }
}
