import java.util.*;



public class StudentsByGroup {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayList<String> names = new ArrayList<>();

        while (!input.equals("END")) {
            names.add(input);

            input = scanner.nextLine();

        }

        names.stream()
                .filter(n -> n.endsWith("2"))
                .sorted((a,b)-> {
                    String[] firstNames = a.split("\\s");
                    String[] secondNames = b.split("\\s");
                    return firstNames[0].compareTo(secondNames[0]);
                })
                .forEach(n-> System.out.println(n.substring(0, n.length()-2)));
    }
}
