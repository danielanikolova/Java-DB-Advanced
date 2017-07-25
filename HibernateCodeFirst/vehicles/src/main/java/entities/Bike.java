package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bikes")
public class Bike extends NonMotorVehicle{


    private Integer shiftsCount;
    private String color;

    public Bike() {
    }

    @Column(name = "shifts_count")
    public Integer getShiftsCount() {
        return shiftsCount;
    }

    public void setShiftsCount(Integer shiftsCount) {
        this.shiftsCount = shiftsCount;
    }

    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
