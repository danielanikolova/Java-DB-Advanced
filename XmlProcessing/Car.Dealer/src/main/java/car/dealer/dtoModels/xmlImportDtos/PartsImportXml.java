package car.dealer.dtoModels.xmlImportDtos;

import car.dealer.dtoModels.jsonImportDtos.PartImportDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartsImportXml {

    @XmlElement(name = "part")
    private List<PartImportDto>partsList;

    public PartsImportXml() {
    }

    public List<PartImportDto> getPartsList() {
        return partsList;
    }

    public void setPartsList(List<PartImportDto> partsList) {
        this.partsList = partsList;
    }
}
