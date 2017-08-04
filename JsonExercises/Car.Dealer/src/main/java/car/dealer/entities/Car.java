package car.dealer.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car {

    private Long id;
    private String make;
    private String model;
    private Double traveledDistanceInKm;
    private Set<Part> carParts;
    private Sale sale;



    public Car() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="make")
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "traveled_distance")
    public Double getTraveledDistanceInKm() {
        return traveledDistanceInKm;
    }

    public void setTraveledDistanceInKm(Double traveledDistanceInKm) {
        this.traveledDistanceInKm = traveledDistanceInKm;
    }

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "cars_parts",
    joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "part_id", referencedColumnName = "id"))
    public Set<Part> getCarParts() {
        return carParts;
    }

    public void setCarParts(Set<Part> carParts) {
        this.carParts = carParts;
    }

    @OneToOne(mappedBy = "car")
    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
}
