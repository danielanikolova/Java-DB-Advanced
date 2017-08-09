package car.dealer.dtoModels.xmlImportDtos;

import car.dealer.dtoModels.jsonImportDtos.CustomerImportDto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerImportXml {

    @XmlElement(name = "customer")
    private List<CustomerImportDto> customers;

    public CustomerImportXml() {
    }

    public List<CustomerImportDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerImportDto> customers) {
        this.customers = customers;
    }
}
