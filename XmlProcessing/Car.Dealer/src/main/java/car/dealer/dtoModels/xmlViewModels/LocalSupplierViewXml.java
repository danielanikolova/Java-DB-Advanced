package car.dealer.dtoModels.xmlViewModels;


import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class LocalSupplierViewXml {

    @Expose
    @XmlAttribute(name = "id")
    private Long Id;
    @Expose
    @XmlAttribute(name = "name")
    private String Name;

    @Expose
    @XmlAttribute(name = "parts-count")
    private int partsCount;

    public LocalSupplierViewXml() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(int partsCount) {
        this.partsCount = partsCount;
    }
}
