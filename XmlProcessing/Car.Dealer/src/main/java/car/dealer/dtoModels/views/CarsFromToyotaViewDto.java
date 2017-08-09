package car.dealer.dtoModels.views;


import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsFromToyotaViewDto {

    @Expose
    @XmlAttribute(name = "id")
    private Long Id;
    @Expose
    @XmlAttribute(name = "make")
    private String Make;
    @Expose
    @XmlAttribute(name = "model")
    private String Model;
    @Expose
    @XmlAttribute(name = "travelled-distance")
    private Long TravelledDistance;

    public CarsFromToyotaViewDto() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public Long getTravelledDistance() {
        return TravelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        TravelledDistance = travelledDistance;
    }
}
