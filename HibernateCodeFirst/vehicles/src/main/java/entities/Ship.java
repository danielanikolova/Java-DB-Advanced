package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ships")
public class Ship extends MotorVehicle{

    private String nationality;
    private String captainName;
    private Integer crewNumber;

    public Ship() {
    }

    @Column(name = "nationality")
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Column(name = "captain_name")
    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    @Column(name = "crew_number")
    public Integer getCrewNumber() {
        return crewNumber;
    }

    public void setCrewNumber(Integer crewNumber) {
        this.crewNumber = crewNumber;
    }
}
