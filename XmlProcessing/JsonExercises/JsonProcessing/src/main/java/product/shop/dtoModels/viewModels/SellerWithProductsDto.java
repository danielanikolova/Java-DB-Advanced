package product.shop.dtoModels.viewModels;


import com.google.gson.annotations.Expose;
import product.shop.dtoModels.bindingModels.ProductNamePriceDto;
import product.shop.dtoModels.bindingModels.xmlViewDto.SuccessfullySoldProducts.SoldProductsXmlList;

import javax.xml.bind.annotation.*;
import java.util.Set;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class SellerWithProductsDto {

    @Expose
    @XmlAttribute(name = "first-name")
    private String firstName;
    @Expose
    @XmlAttribute(name = "last-name")
    private String lastName;
    @Expose
    @XmlElement(name = "sold-products")
    private SoldProductsXmlList soldProducts;

    public SellerWithProductsDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public SoldProductsXmlList getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(SoldProductsXmlList soldProducts) {
        this.soldProducts = soldProducts;
    }
}
