import java.util.*;
import java.util.stream.Collectors;

public class SortStudents {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line= scanner.nextLine();

        Map<String, String>names = new LinkedHashMap<>();

        while (!line.equals("END")){

            String [] nameInfo = line.split(" ");

            String secondName = nameInfo[1];


            names.put(line, secondName);

            line = scanner.nextLine();
        }

        names.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry<String, String>::getValue).reversed()
                        .thenComparing(Map.Entry::getKey).reversed())
                        .forEach(n-> System.out.println(n.getKey()));




    }
}
