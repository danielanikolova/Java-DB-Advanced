package entities;

import javafx.scene.shape.TriangleMesh;

import javax.persistence.*;


@Entity
@Table(name = "carriages")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BasicCarriage implements Carriage{

    private Long id;
    private Integer seatsCapacity;
    private RealVehicle train;

    public BasicCarriage() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "seats_capacity")
    public Integer getSeatsCapacity() {
        return seatsCapacity;
    }

    public void setSeatsCapacity(Integer seatsCapacity) {
        this.seatsCapacity = seatsCapacity;
    }

    @ManyToOne
    @JoinColumn(name = "train_id",
    referencedColumnName = "id")
    public RealVehicle getTrain() {
        return train;
    }

    public void setTrain(RealVehicle train) {
        this.train = train;
    }
}
