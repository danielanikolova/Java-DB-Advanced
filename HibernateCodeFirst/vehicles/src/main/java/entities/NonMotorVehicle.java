package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "nonMotor_vehicles")
public class NonMotorVehicle extends RealVehicle{

    public NonMotorVehicle() {
    }
}
