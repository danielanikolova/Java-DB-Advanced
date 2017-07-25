package entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "vehicles")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class RealVehicle implements Vehicle{

    public Long id;
    public String manufacturer;
    public String model;
    public BigDecimal price;
    public Double maxSpeed;


    public RealVehicle() {
        super();
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setMaxSpeed(Double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    @Column(name = "manufacturer")
    public String getManufacturer() {
        return null;
    }

    @Override
    @Column(name = "model")
    public String getModel() {
        return null;
    }

    @Override
    @Column(name = "price")
    public BigDecimal getPrice() {
        return null;
    }

    @Override
    @Column(name = "max_speed")
    public Double getMaxSpeed() {
        return null;
    }
}
