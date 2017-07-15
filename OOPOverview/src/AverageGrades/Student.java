package AverageGrades;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Double> grades = new ArrayList<Double>();
    private Double averageGrade;

    public Student(String name, List<Double> grades, Double averageGrade) {
        this.name = name;
        this.grades = grades;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void setGrades(List<Double> grades) {
        this.grades = grades;
    }

    public Double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        this.averageGrade = averageGrade;
    }
}
