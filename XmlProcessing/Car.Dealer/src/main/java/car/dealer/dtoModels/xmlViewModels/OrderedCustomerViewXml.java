package car.dealer.dtoModels.xmlViewModels;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderedCustomerViewXml {

    @Expose
    @XmlElement(name = "id")
    private Long Id;
    @Expose
    @XmlElement(name = "name")
    private String Name;
    @Expose
    @XmlElement(name = "birth-date")
    private Date BirthDate;
    @Expose
    @XmlElement(name = "is-youn-driver")
    private Boolean IsYoungDriver;

    public OrderedCustomerViewXml() {
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

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date birthDate) {
        BirthDate = birthDate;
    }

    public Boolean getYoungDriver() {
        return IsYoungDriver;
    }

    public void setYoungDriver(Boolean youngDriver) {
        IsYoungDriver = youngDriver;
    }
}
