package car.dealer.dtoModels.views;


import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
@XmlRootElement(name = "part")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartInfoView {

    @Expose
    @XmlAttribute(name = "name")
    private String Name;
    @Expose
    @XmlAttribute(name = "price")
    private BigDecimal Price;

    public PartInfoView() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal price) {
        Price = price;
    }
}
