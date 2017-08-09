package car.dealer.dtoModels.views;

import car.dealer.entities.Part;
import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarInfoView {
    @Expose
    @XmlAttribute(name = "make")
    private String Make;
    @Expose
    @XmlAttribute(name = "model")
    private String Model;
    @Expose
    @XmlAttribute(name = "travelled-distance")
    private Long TravelledDistance;



    public CarInfoView() {
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
