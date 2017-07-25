package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "passenger_carriages")
public class PassengerCarriage extends BasicCarriage{

    private Integer standingPassenger;

    public PassengerCarriage() {
    }

    @Column(name = "standing_passengers")
    public Integer getStandingPassenger() {
        return standingPassenger;
    }

    public void setStandingPassenger(Integer standingPassenger) {
        this.standingPassenger = standingPassenger;
    }
}
