package car.dealer.dtoModels.views;


import car.dealer.entities.Sale;
import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.Set;

public class OrderedCustomersViewDto {

    @Expose
    private Long Id;
    @Expose
    private String Name;
    @Expose
    private Date BirthDate;
    @Expose
    private Boolean IsYoungDriver;
    @Expose
    private Set<Sale> Sales;

    public OrderedCustomersViewDto() {
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

    public Set<Sale> getSales() {
        return Sales;
    }

    public void setSales(Set<Sale> sales) {
        Sales = sales;
    }
}
