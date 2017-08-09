package car.dealer.dtoModels.xmlViewModels;

import car.dealer.dtoModels.views.CustomersBoughtCarsView;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomersBoughtCarsXmlList {

    @XmlElement(name = "customer")
    List<CustomersBoughtCarsView> customersBoughtCarsViewList;

    public CustomersBoughtCarsXmlList() {
    }

    public List<CustomersBoughtCarsView> getCustomersBoughtCarsViewList() {
        return customersBoughtCarsViewList;
    }

    public void setCustomersBoughtCarsViewList(List<CustomersBoughtCarsView> customersBoughtCarsViewList) {
        this.customersBoughtCarsViewList = customersBoughtCarsViewList;
    }
}
