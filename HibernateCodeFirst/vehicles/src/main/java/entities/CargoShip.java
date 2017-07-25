package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cargo_ships")
public class CargoShip extends Ship{

    private Double maxLoadKilograms;

    public CargoShip() {
    }

    @Column(name = "max_load_kilogram")
    public Double getMaxLoadKilograms() {
        return maxLoadKilograms;
    }

    public void setMaxLoadKilograms(Double maxLoadKilograms) {
        this.maxLoadKilograms = maxLoadKilograms;
    }
}
