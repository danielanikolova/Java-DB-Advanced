package car.dealer.dtoModels.xmlViewModels.Query4;

import car.dealer.dtoModels.views.PartInfoView;
import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.util.Set;


@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarInfoXml {

        @Expose
        @XmlAttribute(name = "make")
        private String Make;
        @Expose
        @XmlAttribute(name = "model")
        private String Model;
        @Expose
        @XmlAttribute(name = "travelled-distance")
        private Long TravelledDistance;
        @Expose
        @XmlElementWrapper(name = "parts")
        @XmlElement(name = "part")
        private Set<PartInfoView> parts;

    public CarInfoXml() {
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

    public Set<PartInfoView> getParts() {
        return parts;
    }

    public void setParts(Set<PartInfoView> parts) {
        this.parts = parts;
    }
}
