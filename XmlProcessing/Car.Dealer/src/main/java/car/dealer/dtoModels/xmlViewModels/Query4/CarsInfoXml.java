package car.dealer.dtoModels.xmlViewModels.Query4;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsInfoXml {

    @XmlElement(name = "car")
    private List<CarInfoXml> cars;

    public CarsInfoXml() {
    }

    public List<CarInfoXml> getCars() {
        return cars;
    }

    public void setCars(List<CarInfoXml> cars) {
        this.cars = cars;
    }
}
