package product.shop.dtoModels.viewModels;

import com.google.gson.annotations.Expose;
import product.shop.dtoModels.bindingModels.Add.UserAddDto;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Date;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductViewDto {
    @Expose
    @XmlAttribute(name = "name")
    private String name;

    @Expose
    @XmlAttribute(name = "price")
    private BigDecimal price;
    @Expose
    @XmlElement(name = "buyer")
    private UserAddDto buyer;
    @Expose
    @XmlElement(name = "name")
    private UserAddDto seller;
    @Expose
    @XmlElement(name = "date")
    private Date date;



    public ProductViewDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public UserAddDto getBuyer() {
        return buyer;
    }

    public void setBuyer(UserAddDto buyer) {
        this.buyer = buyer;
    }


    public UserAddDto getSeller() {
        return seller;
    }

    public void setSeller(UserAddDto seller) {
        this.seller = seller;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
