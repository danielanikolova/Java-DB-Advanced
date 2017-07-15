package AverageGrades;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentsNumber = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<Student>();


        for (int i = 0; i < studentsNumber; i++) {

            String[] student = scanner.nextLine().split(" ");

            if ( student.length<1){
                continue;
            }else {

                String name = student[0];
                List<Double> grades = new ArrayList<Double>();
                Double currentStudentGrades = 0.0;

                for (int j = 1; j < student.length; j++) {
                    String grade = student[j];

                    Double gradeValue = Double.parseDouble(grade);

                    grades.add(gradeValue);
                    currentStudentGrades += gradeValue;

                }

                double averageGrade = currentStudentGrades / (student.length - 1);
                Student currentStudent = new Student(name, grades, averageGrade);
                students.add(currentStudent);
            }
        }

        students.stream()
                .filter(w -> w.getAverageGrade()>=5)
                .sorted(Comparator.comparing(Student::getName)
                        .thenComparing(Comparator.comparing(Student::getAverageGrade).reversed()))
        .forEach(a -> {
            System.out.printf("%s -> %.2f\n", a.getName(), a.getAverageGrade());
        });

    }

}
