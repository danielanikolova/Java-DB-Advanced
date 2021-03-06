package car.dealer.dtoModels.xmlViewModels;

import car.dealer.dtoModels.views.CarsFromToyotaViewDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsFromToyotaXml {

    @XmlElement(name = "car")
    private List<CarsFromToyotaViewDto>cars;

    public CarsFromToyotaXml() {
    }

    public List<CarsFromToyotaViewDto> getCars() {
        return cars;
    }

    public void setCars(List<CarsFromToyotaViewDto> cars) {
        this.cars = cars;
    }
}
