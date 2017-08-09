package car.dealer.dtoModels.views;


import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "sale")
@XmlAccessorType(XmlAccessType.FIELD)
public class SalesWithDiscountDto {

    @Expose
    @XmlElement(name = "car")
    private CarInfoView car;
    @Expose
    @XmlElement(name = "customer-name")
    private String customerName;
    @Expose
    @XmlElement(name = "discount")
    private Double Discount;
    @Expose
    @XmlElement(name = "price")
    private BigDecimal price;
    @Expose
    @XmlElement(name = "price-with-discount")
    private BigDecimal priceWithDiscount;

    public SalesWithDiscountDto() {
    }

    public CarInfoView getCar() {
        return car;
    }

    public void setCar(CarInfoView car) {
        this.car = car;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getDiscount() {
        return Discount;
    }

    public void setDiscount(Double discount) {
        Discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;

    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }
}
