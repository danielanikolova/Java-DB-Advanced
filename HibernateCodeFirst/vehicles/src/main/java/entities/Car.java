package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car extends MotorVehicle{

    private Integer numberOfDoors;
    private Boolean haveInsurance;

    public Car() {
    }

    @Column(name = "doors_number")
    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Column(name = "have_insurance")
    public Boolean getHaveInsurance() {
        return haveInsurance;
    }

    public void setHaveInsurance(Boolean haveInsurance) {
        this.haveInsurance = haveInsurance;
    }
}
