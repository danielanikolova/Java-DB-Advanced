package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "trains")
public class Train extends MotorVehicle{

    private String lokomotive;
    private Integer carriagesNumber;
    private Set<BasicCarriage> carriages;

    public Train() {
    }

    @Column(name = "lokomotive")
    public String getLokomotive() {
        return lokomotive;
    }

    public void setLokomotive(String lokomotive) {
        this.lokomotive = lokomotive;
    }

    @Column(name = "carriage_number")
    public Integer getCarriagesNumber() {
        return carriagesNumber;
    }

    public void setCarriagesNumber(Integer carriagesNumber) {
        this.carriagesNumber = carriagesNumber;
    }

    @OneToMany(mappedBy = "id")
    public Set<BasicCarriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(Set<BasicCarriage> carriages) {
        this.carriages = carriages;
    }
}

