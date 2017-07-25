package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@DiscriminatorValue("Teacher")
public class Teacher extends RealPerson{

    private String email;
    private BigDecimal salaryPerHour;
    private Set<Cours> coursSet;


    public Teacher() {
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "salary_perHour")
    public BigDecimal getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(BigDecimal salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    @OneToMany(mappedBy = "teacher")
    public Set<Cours> getCoursSet() {
        return coursSet;
    }

    public void setCoursSet(Set<Cours> coursSet) {
        this.coursSet = coursSet;
    }
}
