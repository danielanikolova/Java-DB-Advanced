package Students;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (!"End".equals(line)){
            Student student = new Student(line);
            line = scanner.nextLine();
        }
        System.out.println(Student.studentCount);
    }


}
