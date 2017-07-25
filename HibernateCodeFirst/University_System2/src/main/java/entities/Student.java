package entities;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends RealPerson {

        private Double averageGrade;
        private Integer attendance;
        private Set<Cours> coursSet;

    public Student() {
    }

    @Column(name = "averagegrade")
    public Double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Column(name = "attendance")
    public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }

    @ManyToMany
    @JoinTable(name = "students_courses",
    joinColumns = @JoinColumn(name = "students_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
    public Set<Cours> getCoursSet() {
        return coursSet;
    }

    public void setCoursSet(Set<Cours> coursSet) {
        this.coursSet = coursSet;
    }
}
