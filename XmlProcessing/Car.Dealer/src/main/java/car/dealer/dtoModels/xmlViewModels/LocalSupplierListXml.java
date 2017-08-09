package car.dealer.dtoModels.xmlViewModels;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class LocalSupplierListXml {

    @XmlElement(name = "supplier")
    private List<LocalSupplierViewXml> suppliers;

    public LocalSupplierListXml() {
    }

    public List<LocalSupplierViewXml> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<LocalSupplierViewXml> suppliers) {
        this.suppliers = suppliers;
    }
}
