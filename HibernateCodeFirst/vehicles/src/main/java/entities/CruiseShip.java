package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cruise_ships")
public class CruiseShip extends Ship{
    private Integer passengerCapacity;

    public CruiseShip() {
    }

    @Column(name = "passenger_capacity")
    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
