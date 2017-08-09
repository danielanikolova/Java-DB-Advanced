package car.dealer.dtoModels.xmlImportDtos;

import car.dealer.dtoModels.jsonImportDtos.SupplierImportDto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierImportXml {

    @XmlElement(name = "supplier")
    private List<SupplierImportDto> suppliers;

    public SupplierImportXml() {
    }

    public List<SupplierImportDto> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierImportDto> suppliers) {
        this.suppliers = suppliers;
    }
}
