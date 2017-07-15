import java.util.*;

public class ExcellentStudent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Integer>> students = new LinkedHashMap<>();

        while (true){
            String line = scanner.nextLine();
            if ("END".equals(line)){
                break;
            }

            String[] info = line.split("\\s");
            String name = info[0] + " " + info[1];

            List<Integer> grades = new LinkedList<>();

            for (int i = 2; i < info.length; i++) {
                Integer grade = Integer.parseInt(info[i]);
                grades.add(grade);
            }

            students.put(name, grades);

        }

        students.entrySet()
                .stream()
                .filter(a->a.getValue().contains(6))
                .forEach(a-> System.out.println(a.getKey()));

    }
}
