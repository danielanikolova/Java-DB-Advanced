package car.dealer.dtoModels.xmlViewModels;

import car.dealer.dtoModels.views.CustomersBoughtCarsView;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
public class CustomersAndSalesXml {

    @XmlElement(name = "customer")
    private List<CustomersBoughtCarsView> customers;

    public CustomersAndSalesXml() {
    }

    public List<CustomersBoughtCarsView> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomersBoughtCarsView> customers) {
        this.customers = customers;
    }
}
