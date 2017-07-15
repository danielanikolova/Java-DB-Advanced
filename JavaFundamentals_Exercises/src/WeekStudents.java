import java.util.*;
import java.util.stream.Collectors;

public class WeekStudents {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, List<Integer>> students = new LinkedHashMap<>();

        String line = scanner.nextLine();

        while (!line.equals("END")){

            String[] info = line.split("\\s");
            String name = info[0] + " " + info[1];

            List<Integer> grades = new LinkedList<>();

            for (int i = 2; i < info.length; i++) {
                Integer grade = Integer.parseInt(info[i]);
                grades.add(grade);
            }

            students.put(name, grades);

            line = scanner.nextLine();
        }


        students.entrySet()
                .stream()
                .filter(b->{
                    List<Integer> weakGradesForStudent = new ArrayList<Integer>();
                    weakGradesForStudent = b.getValue().stream().filter(k -> k<=3).collect(Collectors.toList());
                    return weakGradesForStudent.size()>=2;
                })
                .forEach(a-> System.out.println(a.getKey()) );


    }

}
