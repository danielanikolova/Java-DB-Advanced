package car.dealer.dtoModels.xmlViewModels;

import car.dealer.dtoModels.views.SalesWithDiscountDto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SalesWithDiscountXml {

    @XmlElement(name = "sale")
    private List<SalesWithDiscountDto>sales;

    public SalesWithDiscountXml() {
    }

    public List<SalesWithDiscountDto> getSales() {
        return sales;
    }

    public void setSales(List<SalesWithDiscountDto> sales) {
        this.sales = sales;
    }
}
