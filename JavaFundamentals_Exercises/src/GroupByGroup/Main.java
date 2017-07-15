package GroupByGroup;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        List<Person> studentsList = new LinkedList<>();

        while (!line.equals("END")) {

            String[] data = line.split("\\s+");

            String name = data[0] + " " + data[1];

            int group = Integer.parseInt(data[2]);

            Person currentStudent = new Person(name, group);

            studentsList.add(currentStudent);

            line = scanner.nextLine();

        }

        Map<Integer, List<String>> namesByGroup =

                studentsList
                        .stream()
                        .collect(Collectors.groupingBy(Person::getGroup,
                                Collectors.mapping(Person::getName, Collectors.toList())));
        namesByGroup.entrySet().stream().forEach((k)->{

            System.out.print(k.getKey()+ " - ");
                    for (int i = 0; i <k.getValue().size()-1 ; i++) {
                        System.out.print( k.getValue().get(i) + ", ");
                    }
                    System.out.println(k.getValue().get(k.getValue().size()-1));

        }
        );


    }

    public static class Person {

        private String name;
        private int group;

        public Person(String name, int group) {
            this.setName(name);
            this.setGroup(group);
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setGroup(int group) {
            this.group = group;
        }

        public String getName() {
            return name;
        }

        public int getGroup() {
            return group;
        }
    }



}
