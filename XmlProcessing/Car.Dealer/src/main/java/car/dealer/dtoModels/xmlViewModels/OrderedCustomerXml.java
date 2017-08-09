package car.dealer.dtoModels.xmlViewModels;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderedCustomerXml {

    @XmlElement(name = "customer")
    private List<OrderedCustomerViewXml> customers;

    public OrderedCustomerXml() {
    }

    public List<OrderedCustomerViewXml> getCustomers() {
        return customers;
    }

    public void setCustomers(List<OrderedCustomerViewXml> customers) {
        this.customers = customers;
    }
}
